package com.example.barbergo.application.haircut;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.haircut.HaircutRepository;

@Service
public class DeleteHaircutUseCase {
    
    private final HaircutRepository haircutRepository;

    public DeleteHaircutUseCase(HaircutRepository haircutRepository) {
        this.haircutRepository = haircutRepository;
    }

    public void execute(UUID id){
        haircutRepository.deleteById(id);
    }
}
