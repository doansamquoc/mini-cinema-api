package com.sam.minicinemaapi.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sam.minicinemaapi.constant.ErrorCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    public static ErrorResponse of(ErrorCode errorCode, String translatedMessage, String path) {
        return new ErrorResponse(
                false,
                errorCode.name(),
                translatedMessage,
                null,
                path,
                null,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, String translatedMessage, String path, String method) {
        return new ErrorResponse(
                false,
                errorCode.name(),
                translatedMessage,
                null,
                path,
                method,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, String translatedMessage, String detail, String path, String method) {
        return new ErrorResponse(
                false,
                errorCode.name(),
                translatedMessage,
                detail,
                path,
                method,
                null,
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(
            ErrorCode errorCode,
            String translatedMessage,
            String detail,
            String path,
            String method,
            Map<String, List<String>> errors
    ) {
        return new ErrorResponse(
                false,
                errorCode.name(),
                translatedMessage,
                detail,
                path,
                method,
                errors,
                LocalDateTime.now()
        );
    }
}
