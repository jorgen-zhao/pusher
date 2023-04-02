package org.acme.pipeline.exception;

import org.acme.pipeline.context.ProcessContext;

import java.util.Objects;

public class ProcessException extends RuntimeException{

    /**
     * 流程处理上下文
     */
    private final ProcessContext processContext;

    public ProcessException(ProcessContext processContext) {
        super();
        this.processContext = processContext;
    }

    public ProcessException(ProcessContext processContext, Throwable cause) {
        super(cause);
        this.processContext = processContext;
    }

    @Override
    public String getMessage() {
        if (Objects.nonNull(this.processContext)) {
            return this.processContext.getResult().getMsg();
        }
        return "RespStatusEnum.CONTEXT_IS_NULL.getMsg()";

    }

    public ProcessContext getProcessContext() {
        return processContext;
    }
}
