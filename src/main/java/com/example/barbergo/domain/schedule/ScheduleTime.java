package com.example.barbergo.domain.schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class ScheduleTime {
    private UUID id;
    private UUID barberId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public ScheduleTime(UUID id, UUID barberId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.barberId = barberId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
