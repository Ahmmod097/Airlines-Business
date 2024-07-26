package com.airlines.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseMessage {
    OPERATION_SUCCESSFUL(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode(), "Operation is successful."),
    RECORD_NOT_FOUND(ApiResponseCode.RECORD_NOT_FOUND.getResponseCode(), "Record not found."),
    REQUEST_PROCESSING_FAILED(ApiResponseCode.DB_OPERATION_FAILED.getResponseCode(), "Request Processing Failed"),
    INTERNAL_SERVICE_EXCEPTION(ApiResponseCode.REQUEST_PROCESSING_FAILED.getResponseCode(), "Request Processing Failed"),
    INVALID_REQUEST_DATA(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "Invalid request data"),
    INVALID_DATE_RANGE(ApiResponseCode.INVALID_REQUEST_DATA.getResponseCode(), "Invalid date range"),

    SOMETHING_WENT_WRONG("E000100", "Something went wrong"),
    ;

    private final String responseCode;
    private final String responseMessage;

    public static String findResponseCodeByMessage(String message) {
        for (ResponseMessage responseMessage : values()) {
            if (responseMessage.getResponseMessage().equals(message)) {
                return responseMessage.getResponseCode();
            }
        }
        return "E000000";
    }
}
