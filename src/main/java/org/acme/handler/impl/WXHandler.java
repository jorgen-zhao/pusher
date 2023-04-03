package org.acme.handler.impl;

import org.acme.handler.AbstractHandler;

import javax.inject.Singleton;

@Singleton
public class WXHandler extends AbstractHandler {


    protected String getCode() {
        return "wx";
    }

    @Override
    public void handle(String code) {
        System.out.println("===> execute " + code + " method ===> ");
    }
}
