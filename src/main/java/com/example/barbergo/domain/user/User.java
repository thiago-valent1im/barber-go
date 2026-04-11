package com.example.barbergo.domain.user;

import java.util.UUID;

import lombok.Getter;

@Getter
public class User {
    
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(UUID id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static User create(UUID id, String name, String email, String password, String role) {
        
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }

        User user = new User(id, name, email, password, role);
        return user;
    }
}
