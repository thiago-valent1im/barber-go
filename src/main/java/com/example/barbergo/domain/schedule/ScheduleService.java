package com.example.barbergo.domain.schedule;

import java.util.UUID;

import lombok.Getter;

@Getter
public class ScheduleService {
    private UUID id;
    private UUID scheduleId;
    private UUID serviceId;
    private Double price;

    public ScheduleService(UUID id, UUID scheduleId, UUID serviceId, Double price) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.serviceId = serviceId;
        this.price = price;
    }
}
