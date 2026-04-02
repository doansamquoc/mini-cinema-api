package com.sam.minicinemaapi.dto.request;

import com.sam.minicinemaapi.constant.Gender;

import java.time.LocalDate;

public record UserRegistrationRequest(
        String fullName,
        LocalDate dob,
        Gender gender,
        String email,
        String phoneNumber,
        String password
) {}
