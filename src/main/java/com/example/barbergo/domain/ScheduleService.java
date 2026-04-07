package com.example.barbergo.domain;

import java.util.UUID;

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
