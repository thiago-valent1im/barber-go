package com.example.barbergo.infrastructure.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.barbergo.domain.user.PasswordEncoder;

@Component
public class PasswordEncoderAdapter implements PasswordEncoder{

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoderAdapter() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String password) {
        return this.passwordEncoder.encode(password);
    }
}
