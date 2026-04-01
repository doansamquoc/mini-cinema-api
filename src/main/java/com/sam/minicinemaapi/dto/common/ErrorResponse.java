package com.sam.minicinemaapi.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sam.minicinemaapi.constant.ErrorCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        boolean success,
        String code,
        String message,
        String detail,
        String path,
        String method,
        Map<String, List<String>> errors,
        LocalDateTime timestamp
) {
    public static ErrorResponse of(ErrorCode errorCode, String path) {
        return new ErrorResponse(
                true,
                errorCode.name(),
                errorCode.getMessage(),
                null,
                path,
                null,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, String path, String method) {
        return new ErrorResponse(
                true,
                errorCode.name(),
                errorCode.getMessage(),
                null,
                path,
                method,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, String detail, String path, String method) {
        return new ErrorResponse(
                true,
                errorCode.name(),
                errorCode.getMessage(),
                detail,
                path,
                method,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(
            ErrorCode errorCode,
            String detail,
            String path,
            String method,
            Map<String, List<String>> errors
    ) {
        return new ErrorResponse(
                true,
                errorCode.name(),
                errorCode.getMessage(),
                detail,
                path,
                method,
                errors,
                LocalDateTime.now()
        );
    }
}
