package com.example.barbergo.domain.barber;

import java.util.UUID;

import com.example.barbergo.domain.user.User;

import lombok.Getter;

@Getter
public class Barber extends User {
    private UUID barberId;
    private Double commission;
    private Double rating;

    public Barber(UUID barberId, UUID userId, String name, String email, String password, Double commission, Double rating) {
        super(userId, name, email, password, "BARBER");
        this.barberId = barberId;
        this.commission = commission;
        this.rating = rating;
    }
}
