package com.example.homework2.dto.user;

public record UserUpdateRequest(
    String username,
    String email,
    String password,
    String phoneNumber) {
}
