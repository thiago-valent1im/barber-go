package com.example.barbergo.domain.schedule;

import java.util.List;
import java.util.UUID;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class Schedule {
    private UUID id;
    private UUID clientId;
    private UUID timeId;
    private List<ScheduleService> services;
    private ScheduleStatus status;

    public Schedule(UUID id, UUID clientId, UUID timeId, List<ScheduleService> services, LocalDate date, LocalTime time, ScheduleStatus status) {
        this.id = id;
        this.clientId = clientId;
        this.timeId = timeId;
        this.services = services;
        this.status = status;
    }
}
