package com.sam.minicinemaapi.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SuccessResponse<T>(boolean success, String message, T data, LocalDateTime timestamp) {
    public static <T> SuccessResponse<T> of(T data) {
        return new SuccessResponse<>(true, "Success", data, LocalDateTime.now());
    }

    public static <T> SuccessResponse<T> of(String message, T data) {
        return new SuccessResponse<>(true, message, data, LocalDateTime.now());
    }

    public static <T> SuccessResponse<T> of(String message) {
        return new SuccessResponse<>(true, message, null, null);
    }

    public static <T> SuccessResponse<T> of() {
        return new SuccessResponse<>(true, "Success", null, null);
    }
}