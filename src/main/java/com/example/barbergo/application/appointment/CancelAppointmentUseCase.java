package com.example.barbergo.application.appointment;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.appointment.AppointmentRepository;

@Service
public class CancelAppointmentUseCase {
    
    private final AppointmentRepository appointmentRepository;

    public CancelAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void execute(UUID id) {
        appointmentRepository.deleteById(id);
    }
}
