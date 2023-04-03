package org.acme.handler.impl;

import org.acme.handler.AbstractHandler;

import javax.inject.Singleton;

@Singleton
public class SMSHandler extends AbstractHandler {


    protected String getCode() {
        return "sms";
    }


    @Override
    public void handle(String code) {
        System.out.println("===> execute " + code + " method ===> ");
    }
}
