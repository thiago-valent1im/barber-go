package com.example.barbergo.application.haircut;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.haircut.dtos.CreateHaircutRequest;
import com.example.barbergo.domain.haircut.Haircut;
import com.example.barbergo.domain.haircut.HaircutRepository;

@Service
public class CreateHaircutUseCase {

    private final HaircutRepository haircutRepository;

    public CreateHaircutUseCase(HaircutRepository serviceRepository){
        this.haircutRepository = serviceRepository;
    }

    public Haircut execute(CreateHaircutRequest request){
        Haircut haircut = new Haircut(
            UUID.randomUUID(), request.name(), request.description(), request.duration(), request.price()
        );
        return haircutRepository.save(haircut);
    }
    
}
