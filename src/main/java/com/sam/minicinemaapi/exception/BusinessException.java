package com.sam.minicinemaapi.exception;

import com.sam.minicinemaapi.constant.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class BusinessException extends RuntimeException {
    ErrorCode errorCode;
    Object[] args;
    Map<String, List<String>> fieldErrors;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = null;
        this.fieldErrors = Map.of();
    }

    public BusinessException(ErrorCode errorCode, Object... args) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = args;
        this.fieldErrors = Map.of();
    }

    public BusinessException(ErrorCode errorCode, Map<String, List<String>> fieldErrors) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = null;
        this.fieldErrors = fieldErrors;
    }

    public BusinessException(ErrorCode errorCode, Map<String, List<String>> fieldErrors, Object... args) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = args;
        this.fieldErrors = fieldErrors;
    }
}
