package com.anmoon.mentionbox.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessException extends Throwable {
    public BusinessException(BusinessExceptionCodes argumentExceptionErrorCode) {
        log.error("chaty:"+argumentExceptionErrorCode.toString());
    }
}
