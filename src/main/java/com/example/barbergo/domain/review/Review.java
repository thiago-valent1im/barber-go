package com.example.barbergo.domain.review;

import java.util.UUID;

import com.example.barbergo.domain.barber.Barber;

import lombok.Getter;

@Getter
public class Review {
    private UUID id;
    private UUID userId;
    private Barber barber;
    private double rating;
    private String comment;

    public Review(UUID id, UUID userId, Barber barber, double rating, String comment) {
        
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (userId == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (barber == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        this.id = id;
        this.userId = userId;
        this.barber = barber;
        this.rating = rating;
        this.comment = comment;
    }

    public Review update(double rating, String comment) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        this.barber.updateReview(this.rating, rating);
        this.rating = rating;
        this.comment = comment;

        return this;
    }
}   
