package com.example.barbergo.application.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.user.User;
import com.example.barbergo.domain.user.UserRepository;


@Service
public class GetUsersUseCase {
    
    private final UserRepository userRepository;
    
    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
