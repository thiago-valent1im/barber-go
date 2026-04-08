package com.example.barbergo.domain.barber;

import java.util.UUID;

public class Barber {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Double commission;
    private Double rating;

    public Barber(UUID id, String name, String email, String phone, String password, Double commission, Double rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.commission = commission;
        this.rating = rating;
    }
}
