package com.example.barbergo.application.barber;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;
import com.example.barbergo.domain.user.UserRepository;

@Service
public class PromoteUserUseCase {
    
    private final BarberRepository barberRepository;
    private final UserRepository userRepository;

    public PromoteUserUseCase(BarberRepository barberRepository, UserRepository userRepository) {
        this.barberRepository = barberRepository;
        this.userRepository = userRepository;
    }

    public Barber execute(UUID userId) {
        Barber barber = userRepository.findById(userId)
                .map(u -> new Barber(u.getId(), u.getName(), u.getEmail(), u.getPassword(), 0.0, 0.0, 0))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return barberRepository.save(barber);   
    }
}
