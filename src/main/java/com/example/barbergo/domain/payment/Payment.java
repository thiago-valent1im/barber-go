package com.example.barbergo.domain.payment;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Payment {
    private UUID id;
    private UUID scheduleId;
    private PaymentStatus status;
    private PaymentType type;
    private Double amount;

    public static Payment create(UUID scheduleId, PaymentType type, Double amount) {
        if (scheduleId == null) {
            throw new IllegalArgumentException("Schedule ID cannot be null.");
        }
        
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null.");
        }
    

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        return new Payment(UUID.randomUUID(), scheduleId, PaymentStatus.PENDING, type, amount);
    }
}