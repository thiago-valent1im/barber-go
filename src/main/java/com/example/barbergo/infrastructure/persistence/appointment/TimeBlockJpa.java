package com.example.barbergo.infrastructure.persistence.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeBlockJpa extends JpaRepository<TimeBlockEntity, UUID> {
    @Query("""
        SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END 
        FROM TimeBlockEntity t 
        WHERE t.barberId = :barberId 
          AND t.startTime <= :endTime 
          AND t.endTime > :startTime 
          AND t.id != :currentBlockId
    """)
    boolean existsOverlapping(
        @Param("barberId") UUID barberId, 
        @Param("startTime") LocalDateTime start, 
        @Param("endTime") LocalDateTime end,
        @Param("currentBlockId") UUID currentBlockId
    );

    @Query("""
        SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END 
        FROM TimeBlockEntity t 
        WHERE t.barberId = :barberId 
          AND t.startTime <= :endTime 
          AND t.endTime > :startTime 
    """)
    boolean existsOverlapping(
        @Param("barberId") UUID barberId, 
        @Param("startTime") LocalDateTime start, 
        @Param("endTime") LocalDateTime end
    );

    @Query("""
        SELECT t
        FROM TimeBlockEntity t
        WHERE t.startTime <= :endTime 
          AND t.endTime > :startTime 
    """)
    List<TimeBlockEntity> findAllByTimeRange(
        @Param("startTime") LocalDateTime start, 
        @Param("endTime") LocalDateTime end
    );
}
