package com.example.barbergo.application.payment;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.payment.Payment;
import com.example.barbergo.domain.payment.PaymentRepository;

@Service
public class GetPaymentByIdUseCase {

    private final PaymentRepository paymentRepository;

    public GetPaymentByIdUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment execute(UUID id) {
        return paymentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Payment not found"));
    }
}
