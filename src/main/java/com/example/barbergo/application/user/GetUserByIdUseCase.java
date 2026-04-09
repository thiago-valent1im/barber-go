package com.example.barbergo.application.user;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.user.User;
import com.example.barbergo.domain.user.UserRepository;


@Service
public class GetUserByIdUseCase {
    
    private final UserRepository userRepository;
    
    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UUID userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
