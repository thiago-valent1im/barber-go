package com.example.barbergo.infrastructure.controller;

import com.example.barbergo.application.barber.DeleteBarberUseCase;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.barbergo.application.barber.CreateBarberUseCase;
import com.example.barbergo.application.barber.GetBarberByIdUseCase;
import com.example.barbergo.application.barber.GetBarbersUseCase;
import com.example.barbergo.application.barber.dtos.CreateBarberRequest;
import com.example.barbergo.domain.barber.Barber;


@RestController
@RequestMapping("/barbers")
public class BarberController {
    
    private final DeleteBarberUseCase deleteBarberUseCase;
    private final GetBarbersUseCase getBarbersUseCase;
    private final GetBarberByIdUseCase getBarberByIdUseCase;
    private final CreateBarberUseCase createBarberUseCase;

    public BarberController(
            GetBarbersUseCase getBarbersUseCase, 
            GetBarberByIdUseCase getBarberByIdUseCase, 
            CreateBarberUseCase createBarberUseCase,
            DeleteBarberUseCase deleteBarberUseCase) {
        this.getBarbersUseCase = getBarbersUseCase;
        this.getBarberByIdUseCase = getBarberByIdUseCase;
        this.createBarberUseCase = createBarberUseCase;
        this.deleteBarberUseCase = deleteBarberUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Barber>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getBarbersUseCase.execute());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getById(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getBarberByIdUseCase.execute(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Barber> create(@RequestBody CreateBarberRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createBarberUseCase.execute(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            deleteBarberUseCase.execute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
