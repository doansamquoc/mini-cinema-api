package com.sam.minicinemaapi.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.minicinemaapi.constant.ErrorCode;
import com.sam.minicinemaapi.dto.common.ErrorResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthResponder {
    ObjectMapper mapper;

    public void sendError(
            HttpServletResponse servletResponse,
            ErrorCode errorCode,
            String path
    ) throws IOException {
        ErrorResponse errorResponse = ErrorResponse.of(errorCode, path);

        servletResponse.setStatus(errorCode.getStatus().value());
        servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());

        servletResponse.getWriter().write(mapper.writeValueAsString(errorResponse));
        servletResponse.flushBuffer();
    }
}
