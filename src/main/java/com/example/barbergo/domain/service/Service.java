package com.example.barbergo.domain.service;

import java.util.UUID;

public class Service {
    private UUID id;
    private String name;
    private String description;
    private String duration;
    private Double price;

    public Service(UUID id, String name, String description, String duration, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
    }
}
