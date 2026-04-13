package com.example.barbergo.application.payment.dtos;

import java.util.UUID;

import com.example.barbergo.domain.payment.PaymentType;

public record CreatePaymentRequest(UUID scheduleId, PaymentType type, Double amount) {

}
