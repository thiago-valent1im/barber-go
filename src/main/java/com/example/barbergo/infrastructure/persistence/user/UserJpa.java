package com.example.barbergo.infrastructure.persistence.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserJpa extends JpaRepository<UserEntity, UUID>{
    Optional<UserEntity> findByEmail(String email);
    
}
