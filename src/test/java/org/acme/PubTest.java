package org.acme;

import com.alibaba.fastjson.JSON;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.request.SendRequest;
import org.acme.response.BaseResult;
import org.acme.business.SendService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Map;

@QuarkusTest
public class PubTest {

    @Inject
    SendService sendService;

    @Test
    void testPub() {
        SendRequest request = new SendRequest();
        request.setSourceCode("code");
//        Map<String,String> map = new HashMap<>();
//        map.put("content", "{\\\"code\\\":\\\"1\\\",\\\"address\\\":\\\"1\\\",\\\"phone\\\":\\\"1\\\"}");
        String msgContent = "{\"code\":\"1#8792\",\"address\":\"菜鸟驿站\",\"phone\":\"15512345678\"}";
        Map<String, String> variables = JSON.parseObject(msgContent, Map.class);

        request.setData(variables);
        request.setTarget("1");
        request.setTemplateCode("1");
        BaseResult result = sendService.send(request);
    }
}
