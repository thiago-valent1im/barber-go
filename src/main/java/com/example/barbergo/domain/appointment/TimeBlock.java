package com.example.barbergo.domain.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TimeBlock {
    private UUID id;
    private UUID barberId;
    private LocalDateTime start;
    private LocalDateTime end;

    public static TimeBlock create(UUID barberId, LocalDateTime start, LocalDateTime end) {
        if (barberId == null) {
            throw new IllegalArgumentException("Barber id cannot be null");
        }

        if (start == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }

        if (end == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }

        return new TimeBlock(UUID.randomUUID(), barberId, start, end);
    }
}
