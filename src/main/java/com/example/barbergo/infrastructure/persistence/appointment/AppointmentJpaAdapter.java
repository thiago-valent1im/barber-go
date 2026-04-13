package com.example.barbergo.infrastructure.persistence.appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.domain.appointment.AppointmentRepository;

@Repository
public class AppointmentJpaAdapter implements AppointmentRepository {

    private final AppointmentJpa appointmentJpa;

    public AppointmentJpaAdapter(AppointmentJpa appointmentJpa) {
        this.appointmentJpa = appointmentJpa;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentJpa.save(AppointmentEntity.fromDomain(appointment)).toDomain();
    }

    @Override
    public void deleteById(UUID id) {
        appointmentJpa.deleteById(id);
    }

    @Override
    public Optional<Appointment> findById(UUID id) {
        return appointmentJpa.findById(id).map(AppointmentEntity::toDomain);
    }

    @Override
    public List<Appointment> findByUserId(UUID userId) {
        return appointmentJpa.findByUserId(userId).stream().map(AppointmentEntity::toDomain).toList();
    }

    @Override
    public List<Appointment> findByBarberId(UUID barberId) {
        return appointmentJpa.findByBarberId(barberId).stream().map(AppointmentEntity::toDomain).toList();
    }
    
}
