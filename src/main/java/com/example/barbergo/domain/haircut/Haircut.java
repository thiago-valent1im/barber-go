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

    public static Haircut create(UUID id, String name, String description, Integer duration, Double price) {
        
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }

        if (duration == null || duration < 0) {
            throw new IllegalArgumentException("Duration cannot be null or less than 0");
        }

        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price cannot be null or less than 0");
        }
        
        Haircut haircut = new Haircut(id, name, description, duration, price);
        return haircut;
    }
}
