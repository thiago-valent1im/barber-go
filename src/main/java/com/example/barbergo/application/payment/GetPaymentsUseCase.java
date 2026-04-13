package com.example.barbergo.application.payment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.payment.Payment;
import com.example.barbergo.domain.payment.PaymentRepository;

@Service
public class GetPaymentsUseCase {

    private final PaymentRepository paymentRepository;

    public GetPaymentsUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> execute() {
        return paymentRepository.findAll();
    }
}
