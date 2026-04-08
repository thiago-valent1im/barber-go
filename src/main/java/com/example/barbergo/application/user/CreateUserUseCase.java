package com.example.barbergo.application.user;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.user.dtos.CreateUserRequest;
import com.example.barbergo.domain.user.PasswordEncoder;
import com.example.barbergo.domain.user.User;
import com.example.barbergo.domain.user.UserRepository;


@Service
public class CreateUserUseCase {

    private final UserRepository userRepository; 
    private final PasswordEncoder passwordEncoder;
    
    public CreateUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(CreateUserRequest request) {
        User user = new User(
            UUID.randomUUID(), request.name(), request.email(), passwordEncoder.encode(request.password()), request.role()
        );
        return userRepository.save(user);
    }
    
}
