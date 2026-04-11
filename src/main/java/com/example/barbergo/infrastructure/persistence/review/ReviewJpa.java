package com.example.barbergo.infrastructure.persistence.review;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReviewJpa extends JpaRepository<ReviewEntity, UUID> {
    
    @Query("SELECT r FROM ReviewEntity r WHERE r.userId = :userId AND r.barber.id = :barberId")
    Optional<ReviewEntity> findByUserIdAndBarberId(@Param("userId") UUID userId, @Param("barberId") UUID barberId);
    List<ReviewEntity> findByUserId(UUID userId);

    @Query("SELECT r FROM ReviewEntity r WHERE r.barber.id = :barberId")
    List<ReviewEntity> findByBarberId(@Param("barberId") UUID barberId);

}
