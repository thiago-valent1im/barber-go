package com.example.barbergo.application.payment;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.payment.dtos.CreatePaymentRequest;
import com.example.barbergo.domain.payment.Payment;
import com.example.barbergo.domain.payment.PaymentRepository;

@Service
public class CreatePaymentsUseCase {

    private final PaymentRepository paymentRepository;

    public CreatePaymentsUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment execute(CreatePaymentRequest request) {
        Payment payment = Payment.create(request.method());
        return paymentRepository.save(payment);
    }
}
