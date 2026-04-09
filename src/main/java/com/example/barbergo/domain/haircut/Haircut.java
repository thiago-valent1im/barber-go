package com.example.barbergo.domain.haircut;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Haircut {
    private UUID id;
    private String name;
    private String description;
    private Integer duration;
    private Double price;

    public Haircut(UUID id, String name, String description, Integer duration, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
    }
}
