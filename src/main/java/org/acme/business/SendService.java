package org.acme.business;

import org.acme.request.SendRequest;
import org.acme.response.BaseResult;

public interface SendService {

    BaseResult send(SendRequest request);
}
