package com.example.barbergo.application.payment.dtos;

import java.util.UUID;

import com.example.barbergo.domain.payment.PaymentMethod;

public record CreatePaymentRequest(PaymentMethod method) {
    
}
