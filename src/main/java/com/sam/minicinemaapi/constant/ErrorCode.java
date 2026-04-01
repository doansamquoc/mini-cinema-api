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
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "error.unauthorized"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "error.access_denied"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "error.resource_not_found");

    HttpStatus status;
    String messageKey;
}
