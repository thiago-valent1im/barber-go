package com.example.barbergo.application.appointment;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.appointment.dtos.RescheduleAppointmentRequest;
import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.domain.appointment.AppointmentRepository;
import com.example.barbergo.domain.appointment.TimeBlockRepository;

@Service
public class RescheduleAppointmentUseCase {
    
    private final AppointmentRepository appointmentRepository;
    private final TimeBlockRepository timeBlockRepository;

    public RescheduleAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            TimeBlockRepository timeBlockRepository) {
        this.appointmentRepository = appointmentRepository;
        this.timeBlockRepository = timeBlockRepository;
    }

    public Appointment execute(RescheduleAppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(request.appointmentId())
                .orElseThrow(()-> new IllegalArgumentException("Appointment not found"));
        UUID oldTimeBlockId = appointment.getTime().getId();

        appointment.schedule(request.barberId(), request.start());
        
        if (timeBlockRepository.existsOverlapping(appointment.getTime().getStart(), appointment.getTime().getEnd(), request.barberId(), oldTimeBlockId))
            throw new IllegalStateException("Time is not available");

        return appointmentRepository.save(appointment);
    }
}
