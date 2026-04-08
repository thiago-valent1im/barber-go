package com.example.barbergo.application.user;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.user.User;
import com.example.barbergo.domain.user.UserRepository;


@Service
public class DeleteUserUseCase {
    
    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
    }
}
