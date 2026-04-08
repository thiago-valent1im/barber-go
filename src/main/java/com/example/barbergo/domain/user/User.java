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

    public void validate() {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }
}
