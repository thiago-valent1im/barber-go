package com.example.barbergo.domain.payment;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Payment {
    private UUID id;
    private PaymentStatus status;
    private PaymentMethod method;

    public static Payment create(PaymentMethod method) {

        if (method == null) {
            throw new IllegalArgumentException("Payment method cannot be null.");
        }

        return new Payment(UUID.randomUUID(), PaymentStatus.PENDING, method);
    }
}