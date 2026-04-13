package com.example.barbergo.application.appointment.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record RescheduleAppointmentRequest(UUID appointmentId, UUID barberId, LocalDateTime start) {
    
}
