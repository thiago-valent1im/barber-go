package com.example.barbergo.domain.review;

import java.util.UUID;

public class Review {
    private UUID id;
    private UUID clientId;
    private UUID barberId;
    private int rating;
    private String comment;

    public Review(UUID id, UUID clientId, UUID barberId, int rating, String comment) {
        this.id = id;
        this.clientId = clientId;
        this.barberId = barberId;
        this.rating = rating;
        this.comment = comment;
    }
}
