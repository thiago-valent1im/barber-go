package com.example.barbergo.infrastructure.persistence.haircut;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaircutJpa extends JpaRepository<HaircutEntity, UUID> {
    
}
