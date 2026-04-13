package com.example.barbergo.domain.appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    void deleteById(UUID id);
    Optional<Appointment> findById(UUID id);
    List<Appointment> findByUserId(UUID userId);
    List<Appointment> findByBarberId(UUID barberId);
}
