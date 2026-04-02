package com.sam.minicinemaapi.dto.response;

import com.sam.minicinemaapi.constant.Gender;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String fullName,
        LocalDate dob,
        Gender gender,
        String email,
        String phoneNumber
) {}
