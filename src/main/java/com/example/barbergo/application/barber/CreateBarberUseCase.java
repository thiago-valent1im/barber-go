package com.example.barbergo.application.barber;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.barber.dtos.CreateBarberRequest;
import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;
import com.example.barbergo.domain.user.PasswordEncoder;


@Service
public class CreateBarberUseCase {
    
    private final BarberRepository barberRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateBarberUseCase(BarberRepository barberRepository, PasswordEncoder passwordEncoder) {
        this.barberRepository = barberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Barber execute(CreateBarberRequest request) {
        Barber barber = Barber.create(UUID.randomUUID(), request.name(), request.email(), passwordEncoder.encode(request.password()), 0.0, 0.0, 0);
        return barberRepository.save(barber);
    }
}
