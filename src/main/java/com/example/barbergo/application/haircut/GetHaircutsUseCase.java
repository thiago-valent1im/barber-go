package com.example.barbergo.application.haircut;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.haircut.Haircut;
import com.example.barbergo.domain.haircut.HaircutRepository;


@Service
public class GetHaircutsUseCase {
    
    private final HaircutRepository haircutRepository;
    
    public GetHaircutsUseCase(HaircutRepository haircutRepository) {
        this.haircutRepository = haircutRepository;
    }

    public List<Haircut> execute() {
        return haircutRepository.findAll();
    }
}
