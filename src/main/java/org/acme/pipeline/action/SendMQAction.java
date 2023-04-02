package org.acme.pipeline.action;

import org.acme.pipeline.BusinessProcess;
import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.SendTaskModel;
import org.acme.pipeline.context.TaskInfo;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SendMQAction implements BusinessProcess<SendTaskModel> {

    @Override
    public void process(ProcessContext<SendTaskModel> context) {

        SendTaskModel model = context.getModel();
        List<TaskInfo> taskInfos = model.getTaskInfos();
        System.out.println(context);
        System.out.println(model);
        taskInfos.forEach(System.out::println);
    }
}
