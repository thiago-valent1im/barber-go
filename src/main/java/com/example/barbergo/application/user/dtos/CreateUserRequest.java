package com.example.barbergo.application.user.dtos;

public record CreateUserRequest(String name, String email, String password, String role) {
    
}
