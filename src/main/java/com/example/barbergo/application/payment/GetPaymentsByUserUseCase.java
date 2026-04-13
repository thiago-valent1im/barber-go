package com.example.barbergo.application.payment;

import java.util.List;
import java.util.UUID;

import com.example.barbergo.domain.payment.Payment;
import com.example.barbergo.domain.payment.PaymentRepository;

public class GetPaymentsByUserUseCase {

    private final PaymentRepository paymentRepository;

    public GetPaymentsByUserUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // public List<Payment> execute(UUID userId) {
    //     return paymentRepository.findByUserId(userId);
    // }
}
