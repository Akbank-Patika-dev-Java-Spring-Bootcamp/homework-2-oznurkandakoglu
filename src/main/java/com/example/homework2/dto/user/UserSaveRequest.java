package com.example.homework2.dto.user;

import com.example.homework2.enums.UserType;

public record UserSaveRequest(
        String username,
        String phoneNumber,
        String password,
        String email,
        UserType userType) {
}
