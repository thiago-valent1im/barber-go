package com.example.barbergo.application.payment;

import com.example.barbergo.domain.payment.PaymentRepository;

public class NotifyPaymentUseCase {

    private final PaymentRepository paymentRepository;

    public NotifyPaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    
}
