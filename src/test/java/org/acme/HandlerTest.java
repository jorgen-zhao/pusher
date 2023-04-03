package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.handler.Handler;
import org.acme.handler.HandlerHolder;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class HandlerTest {

    @Inject
    HandlerHolder handlerHolder;

    @Test
    void testExecute() {
        String code = "sms";
        Handler handler = handlerHolder.getHandler(code);
        handler.handle(code);
    }
}
