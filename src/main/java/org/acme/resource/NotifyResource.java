package org.acme.resource;

import com.alibaba.fastjson.JSON;
import org.acme.request.SendRequest;
import org.acme.response.BaseResult;
import org.acme.service.SendService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("notify")
public class NotifyResource {

    @Inject
    SendService sendService;

    @GET
    @Path("/send")
    public BaseResult send() {
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
        return result;
    }
}
