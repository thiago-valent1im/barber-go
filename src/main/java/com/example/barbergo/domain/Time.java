package com.example.barbergo.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Time {
    private UUID id;
    private UUID barberId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Time(UUID id, UUID barberId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.barberId = barberId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
