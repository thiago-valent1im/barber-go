package com.example.barbergo.domain.payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository {
    Payment save(Payment payment);
    void deleteById(UUID id);
    Optional<Payment> findById(UUID id);
    List<Payment> findAll();
}
