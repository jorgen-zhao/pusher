package org.acme.pipeline.action;

import cn.hutool.core.util.StrUtil;
import org.acme.pipeline.BusinessProcess;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.response.BaseResult;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PreParamCheckAction implements BusinessProcess<SendTaskModel> {


    @Override
    public void process(ProcessContext<SendTaskModel> context) {

        SendTaskModel model = context.getModel();
        String templateCode = model.getTemplateCode();
        if (StrUtil.isBlank(templateCode)) {
            context.setNeedBreak(true) ;
            context.setResult(BaseResult.fail());
            return;
        }
    }
}
