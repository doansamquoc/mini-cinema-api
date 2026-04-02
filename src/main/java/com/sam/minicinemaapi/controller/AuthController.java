package com.sam.minicinemaapi.controller;

import com.sam.minicinemaapi.constant.EndpointConstant;
import com.sam.minicinemaapi.dto.common.SuccessResponse;
import com.sam.minicinemaapi.dto.request.AuthenticateRequest;
import com.sam.minicinemaapi.dto.request.UserRegistrationRequest;
import com.sam.minicinemaapi.dto.response.AuthResponse;
import com.sam.minicinemaapi.dto.response.UserResponse;
import com.sam.minicinemaapi.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(EndpointConstant.PREFIX_V1 + "/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @PostMapping("/login")
    ResponseEntity<SuccessResponse<AuthResponse>> login(@RequestBody AuthenticateRequest request) {
        AuthResponse authResponse = authService.login(request);
        return ResponseEntity.ok(SuccessResponse.of(authResponse));
    }

    @PostMapping("/register")
    ResponseEntity<SuccessResponse<UserResponse>> register(@Valid @RequestBody UserRegistrationRequest request) {
        UserResponse userResponse = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.of(userResponse));
    }
}
