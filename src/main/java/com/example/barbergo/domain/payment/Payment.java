package com.example.barbergo.domain.payment;

import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID scheduleId;
    private PaymentType type;
    private Double amount;

    public Payment(UUID id, UUID scheduleId, PaymentType type, Double amount) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.type = type;
        this.amount = amount;
    }
}