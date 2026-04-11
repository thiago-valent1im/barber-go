package com.example.barbergo.application.review.dtos;

import java.util.UUID;

public record SaveReviewRequest(UUID userId, UUID barberId, int rating, String comment) {
    
}
