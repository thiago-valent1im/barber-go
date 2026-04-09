package com.example.barbergo.application.barber;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.barber.BarberRepository;


@Service
public class DeleteBarberUseCase {
    
    private final BarberRepository barberRepository;
    
    public DeleteBarberUseCase(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public void execute(UUID id) {
        barberRepository.deleteById(id);
    }
}
