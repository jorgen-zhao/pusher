package org.acme.resource;

import org.acme.request.SendRequest;
import org.acme.response.BaseResult;
import org.acme.service.SendService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("notify")
public class NotifyResource {

    @Inject
    SendService sendService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public BaseResult send(SendRequest request) {
        BaseResult result = sendService.send(request);
        return result;
    }
}
