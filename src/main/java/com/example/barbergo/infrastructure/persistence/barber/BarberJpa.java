package com.example.barbergo.infrastructure.persistence.barber;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberJpa extends JpaRepository<BarberEntity, UUID>{
    
}
