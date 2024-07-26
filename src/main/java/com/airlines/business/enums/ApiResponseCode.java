package com.airlines.business.enums;

import com.airlines.business.common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ApiResponseCode {
    OPERATION_SUCCESSFUL("S100000"),
    RECORD_NOT_FOUND("E000101"),
    INVALID_REQUEST_DATA("E000102"),
    REQUEST_PROCESSING_FAILED("E000106"),
    DB_OPERATION_FAILED("E000010"),
    ALREADY_EXISTS("E000121"),
    PHONE_NUMBER_ALREADY_USED("E000122"),
    UNAUTHORIZED("GE4001"),
    AlREADY_EXIST("E00185"),
    NOT_EXIST("E00186"),
    ;

    private String responseCode;

    public static boolean isOperationSuccessful(ApiResponse apiResponse) {
        return Objects.nonNull(apiResponse) && apiResponse.getResponseCode().equals(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode());
    }

    public static boolean isNotOperationSuccessful(ApiResponse apiResponse) {
        return !isOperationSuccessful(apiResponse);
    }

    public static boolean isOperationSuccessfulByCode(String responseCode){
        return Objects.nonNull(responseCode) && responseCode.equals(ApiResponseCode.OPERATION_SUCCESSFUL.getResponseCode());
    }
    public static boolean isNotOperationSuccessfulByCode(String responseCode){
        return !isOperationSuccessfulByCode(responseCode);
    }
}
