package org.acme.request;


import lombok.Data;

import java.util.Map;

@Data
public class SendRequest {

    private String templateCode;

    private Map<String, String> data;

    private String sourceCode;

    private String target;

}
