package com.example.barbergo.application.appointment;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.domain.appointment.AppointmentRepository;

@Service
public class GetAppointmentsByBarberUseCase {
    
    private final AppointmentRepository appointmentRepository;
    
    public GetAppointmentsByBarberUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> execute(UUID barberId) {
        return appointmentRepository.findByBarberId(barberId);
    }
}
