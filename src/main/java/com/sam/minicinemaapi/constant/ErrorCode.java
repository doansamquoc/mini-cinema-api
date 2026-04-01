package com.sam.minicinemaapi.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized access"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "Access denied");


    HttpStatus status;
    String message;
}
