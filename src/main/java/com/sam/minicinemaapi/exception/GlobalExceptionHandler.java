package com.sam.minicinemaapi.exception;

import com.sam.minicinemaapi.dto.common.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalExceptionHandler {
    MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<ErrorResponse> handleBusiness(BusinessException be, HttpServletRequest servletRequest, Locale locale) {
        String translatedMessage = messageSource.getMessage(be.getErrorCode().getMessageKey(), null, locale);
        ErrorResponse response = ErrorResponse.of(be.getErrorCode(), translatedMessage, servletRequest.getRequestURI());
        return ResponseEntity.status(be.getErrorCode().getStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    ErrorResponse handleGeneric(Exception e) {
        return null;
    }
}
