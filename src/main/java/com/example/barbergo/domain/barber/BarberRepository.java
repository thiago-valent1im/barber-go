package com.example.barbergo.domain.barber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository {
    Barber save(Barber barber);
    void deleteById(UUID id);
    Optional<Barber> findById(UUID id);
    List<Barber> findAll();
}
