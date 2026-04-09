package com.example.barbergo.application.barber;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;

@Service
public class GetBarberByIdUseCase {
    
    private final BarberRepository barberRepository;

    public GetBarberByIdUseCase(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public Barber execute(UUID id) {
        return barberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Barber not found"));
    }
}
