package org.acme.pipeline.action;

import org.acme.pipeline.BusinessProcess;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.response.BaseResult;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SendMQAction implements BusinessProcess<SendTaskModel> {

    @Override
    public void process(ProcessContext<SendTaskModel> context) {
    }
}
