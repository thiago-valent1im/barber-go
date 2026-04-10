package com.example.barbergo.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.barbergo.application.haircut.CreateHaircutUseCase;
import com.example.barbergo.application.haircut.GetHaircutsUseCase;
import com.example.barbergo.application.haircut.dtos.CreateHaircutRequest;
import com.example.barbergo.domain.haircut.Haircut;

@RestController
@RequestMapping("/haircuts")
public class HaircutController {

    private final CreateHaircutUseCase createHaircutUseCase;
    private final GetHaircutsUseCase getHaircutsUseCase;

    public HaircutController(CreateHaircutUseCase createHaircutUseCase, GetHaircutsUseCase getHaircutsUseCase) {
        this.createHaircutUseCase = createHaircutUseCase;
        this.getHaircutsUseCase = getHaircutsUseCase;
    }

    @PostMapping
    public ResponseEntity<Haircut> create(@RequestBody CreateHaircutRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createHaircutUseCase.execute(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Haircut>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(getHaircutsUseCase.execute());
    }
}
