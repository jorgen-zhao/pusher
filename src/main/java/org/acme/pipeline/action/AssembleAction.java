package org.acme.pipeline.action;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.acme.pipeline.BusinessProcess;
import org.acme.pipeline.context.ContentModel;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.pipeline.context.TaskInfo;
import org.acme.pipeline.context.content.SMSContentModel;
import org.acme.utils.ContentHolderUtil;
import org.acme.utils.PlaceholderResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class AssembleAction implements BusinessProcess<SendTaskModel> {

    @Inject
    PlaceholderResolver placeholderResolver;

    @Override
    public void process(ProcessContext<SendTaskModel> context) {

        SendTaskModel model = context.getModel();
        String templateCode = model.getTemplateCode();
        // 根据templateCode组装数据
        Map<String, String> data = model.getData();

        List<TaskInfo> taskInfos = assembleTaskInfo(templateCode, data);
        model.setTaskInfos(taskInfos);
    }

    private List<TaskInfo> assembleTaskInfo(String templateCode, Map<String, String> data) {
        ArrayList<TaskInfo> taskInfos = new ArrayList<>();


        TaskInfo info = new TaskInfo();
        info.setContentModel(getContentModelValue(templateCode, data));
        info.setTarget("");
        info.setTemplateCode(templateCode);
        info.setSendChanel("");
        info.setSourceCode("");
        taskInfos.add(info);

        return taskInfos;
    }

    private ContentModel getContentModelValue(String templateCode, Map<String, String> data) {

        // msgContent
        // {\"path\":\"\",\"miniProgramId\":\"\",\"templateId\":\"ylGskR8FSaKF3YmPmoQlSf8QXPOTI4t2SwugjoBBR_0\",\"url\":\"{$url}\",\"linkType\":\"10\",\"officialAccountParam\":\"{\\\"first\\\":\\\"a\\\",\\\"keyword1\\\":\\\"a\\\",\\\"keyword2\\\":\\\"a\\\",\\\"remark\\\":\\\"a\\\"}\"}
        String msgContent = "{\"url\":\"\",\"content\":\"您好，请凭取件码：{$code}，至{$address}取件，若有问题请咨询{$phone}\"}";
        JSONObject jsonObject = JSON.parseObject(msgContent);
        //
        Field[] fields = ReflectUtil.getFields(SMSContentModel.class);
        ContentModel contentModel = ReflectUtil.newInstance(SMSContentModel.class);

        for (Field field : fields) {
            String originValue = jsonObject.getString(field.getName());

            if (StrUtil.isNotBlank(originValue)) {
//                String resultValue = ContentHolderUtil.replacePlaceHolder(originValue, data);
                String resultValue = placeholderResolver.resolveByStrMap(originValue, data);
                Object resultObj = JSONUtil.isJsonObj(resultValue) ? JSONUtil.toBean(resultValue, field.getType()) : resultValue;
                ReflectUtil.setFieldValue(contentModel, field, resultObj);
            }
        }
        return contentModel;
    }
}
