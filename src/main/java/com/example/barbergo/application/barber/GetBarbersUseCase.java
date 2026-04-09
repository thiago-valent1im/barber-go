package com.example.barbergo.application.barber;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;

@Service
public class GetBarbersUseCase {
    
    private final BarberRepository barberRepository;

    public GetBarbersUseCase(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<Barber> execute() {
        return barberRepository.findAll();
    }
}
