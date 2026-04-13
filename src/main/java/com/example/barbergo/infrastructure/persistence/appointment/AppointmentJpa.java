package com.example.barbergo.infrastructure.persistence.appointment;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentJpa extends JpaRepository<AppointmentEntity, UUID>{
    @Query("SELECT a FROM AppointmentEntity a WHERE a.userId = :userId")
    List<AppointmentEntity> findByUserId(@Param("userId") UUID userId);

    @Query("SELECT a FROM AppointmentEntity a WHERE a.time.barberId = :barberId")
    List<AppointmentEntity> findByBarberId(@Param("barberId") UUID barberId);
}
