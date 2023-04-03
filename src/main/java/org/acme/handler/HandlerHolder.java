package org.acme.handler;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class HandlerHolder {

    private final Map<String, Handler> map = new HashMap<>();

    public void register(String code, Handler handler) {
        map.put(code, handler);
    }

    public Handler getHandler(String code) {
        return map.get(code);
    }
}
