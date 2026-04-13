package com.example.barbergo.application.appointment.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateAppointmentRequest(UUID userId, UUID barberId, LocalDateTime start, List<UUID> haircuts) {
    
}
