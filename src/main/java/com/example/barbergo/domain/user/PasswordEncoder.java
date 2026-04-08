package com.example.barbergo.domain.user;

import org.springframework.stereotype.Component;

@Component
public interface PasswordEncoder {
    public String encode(String password);
}
