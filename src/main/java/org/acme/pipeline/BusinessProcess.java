package org.acme.pipeline;

import org.acme.pipeline.context.ProcessContext;
import org.acme.pipeline.context.ProcessModel;

public interface BusinessProcess<T extends ProcessModel> {


    void process(ProcessContext<T> context);
}
