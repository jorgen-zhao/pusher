package org.acme.pipeline.config;

import org.acme.pipeline.ProcessController;
import org.acme.pipeline.ProcessTemplate;
import org.acme.pipeline.action.AssembleAction;
import org.acme.pipeline.action.PreParamCheckAction;
import org.acme.pipeline.action.SendMQAction;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class pipelineConfig {

    @Inject
    PreParamCheckAction preParamCheckAction;

    @Inject
    AssembleAction assembleAction;

    @Inject
    SendMQAction sendMQAction;

    public ProcessTemplate commonSendTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(preParamCheckAction, assembleAction,
                 sendMQAction));
        return processTemplate;
    }

    @ApplicationScoped
    @Produces
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>(1);
        templateConfig.put("call", commonSendTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }
}
