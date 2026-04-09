package com.example.barbergo.application.barber;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.barber.dtos.CreateBarberRequest;
import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;


@Service
public class CreateBarberUseCase {
    
    private final BarberRepository barberRepository;

    public CreateBarberUseCase(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public Barber execute(CreateBarberRequest request) {
        Barber barber = new Barber(UUID.randomUUID(), request.name(), request.email(), request.password(), 0.0, 0.0);
        return barberRepository.save(barber);
    }
}
