package org.acme.handler;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public abstract class AbstractHandler implements Handler {


    @Inject
    HandlerHolder handlerHolder;

    protected abstract String getCode();

    void onStart(@Observes StartupEvent ev) {
        System.out.println(getCode() + " init.....");
        handlerHolder.register(getCode(), this);
    }
}
