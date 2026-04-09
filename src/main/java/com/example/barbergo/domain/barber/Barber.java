package com.example.barbergo.domain.barber;

import java.util.UUID;

import com.example.barbergo.domain.user.User;

import lombok.Getter;

@Getter
public class Barber extends User {
    private UUID id;
    private Double commission;
    private Double rating;

    public Barber(UUID id, String name, String email, String password, Double commission, Double rating) {
        super(id, name, email, password, "BARBER");
        this.commission = commission;
        this.rating = rating;
    }
}
