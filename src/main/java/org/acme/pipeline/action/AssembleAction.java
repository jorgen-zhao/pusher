package org.acme.pipeline.action;

import cn.hutool.core.util.ReferenceUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.acme.pipeline.BusinessProcess;
import org.acme.pipeline.context.ContentModel;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.pipeline.context.TaskInfo;
import org.acme.pipeline.context.content.WXTemplate;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class AssembleAction implements BusinessProcess<SendTaskModel> {

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

        return new ArrayList<>();
    }

    private static ContentModel getContentModelValue(String templateCode, Map<String, String> data) {

        // msgContent
        // {\"path\":\"\",\"miniProgramId\":\"\",\"templateId\":\"ylGskR8FSaKF3YmPmoQlSf8QXPOTI4t2SwugjoBBR_0\",\"url\":\"{$url}\",\"linkType\":\"10\",\"officialAccountParam\":\"{\\\"first\\\":\\\"a\\\",\\\"keyword1\\\":\\\"a\\\",\\\"keyword2\\\":\\\"a\\\",\\\"remark\\\":\\\"a\\\"}\"}
        String msgContent = "";
        JSONObject jsonObject = JSON.parseObject(msgContent);
        //
        Field[] fields = ReflectUtil.getFields(WXTemplate.class);
        ReflectUtil.newInstance(WXTemplate.class);

        for (Field field : fields) {
            String originValue = jsonObject.getString(field.getName());

            if (StrUtil.isNotBlank(originValue)) {

            }
        }
        return null;
    }
}
