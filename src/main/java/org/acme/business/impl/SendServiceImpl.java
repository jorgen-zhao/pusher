package org.acme.business.impl;

import org.acme.pipeline.ProcessController;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.request.SendRequest;
import org.acme.response.BaseResult;
import org.acme.business.SendService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SendServiceImpl implements SendService {


    @Inject
    ProcessController processController;

    @Override
    public BaseResult send(SendRequest request) {

        // CHAIN ENTRY
        SendTaskModel sendTaskModel = new SendTaskModel();
        sendTaskModel.setSourceCode(request.getSourceCode());
        sendTaskModel.setData(request.getData());
        sendTaskModel.setTarget(request.getTarget());
        sendTaskModel.setTemplateCode(request.getTemplateCode());


        ProcessContext context = new ProcessContext();
        context.setCode("call");
        context.setModel(sendTaskModel);
        context.setNeedBreak(false);
        context.setResult(BaseResult.success());

        ProcessContext process = processController.process(context);
        return new BaseResult(process.getResult().getCode(), process.getResult().getMsg());
    }
}
