package org.acme.service.impl;

import org.acme.pipeline.ProcessController;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.request.SendRequest;
import org.acme.response.BaseResult;
import org.acme.service.SendService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SendServiceImpl implements SendService {


    @Inject
    ProcessController processController;

    @Override
    public BaseResult send(SendRequest request) {

        // CHAIN ENTRY
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .sourceCode(request.getSourceCode())
                .target(request.getTarget())
                .templateCode(request.getTemplateCode())
                .data(request.getData())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code("call")
                .model(sendTaskModel)
                .needBreak(false)
                .result(BaseResult.success())
                .build();

        ProcessContext process = processController.process(context);
        return new BaseResult(process.getResult().getCode(), process.getResult().getMsg());
    }
}
