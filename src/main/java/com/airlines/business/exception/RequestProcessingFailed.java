package com.airlines.business.exception;

import com.airlines.business.enums.ResponseMessage;

public class RequestProcessingFailed extends CustomRootException{
    public RequestProcessingFailed(ResponseMessage responseMessage) {
        super(responseMessage);
    }

    public RequestProcessingFailed(String messageCode, String messageKey) {
        super(messageCode, messageKey);
    }

    public RequestProcessingFailed(String message) {
        super(message);
    }
}
