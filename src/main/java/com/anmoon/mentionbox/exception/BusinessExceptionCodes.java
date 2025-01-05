package com.anmoon.mentionbox.exception;

public enum BusinessExceptionCodes {
//    # group(set range) should not change // migrate
//   level, type, group, id, msg
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION_ERROR_CODE(1, "request.missing.parameter"),
    ARGUMENT_EXCEPTION_ERROR_CODE(2, "request.illegal.parameter"),
    MISSING_REQUEST_BODY_ERROR_CODE(3, "request.missing.body"),
    TECHNICAL_ERROR(4, "request.technical.error"),
    AUTH_ERROR(5, "authentication.error");


//User-related errors (1000-1999):
//    - 1001: User not found
//    - 1002: Invalid user credentials
//Order-related errors (2000-2999):
//    - 2001: Order not found
//    - 2002: Invalid order status

    BusinessExceptionCodes(int i, String s) {
    }
}
