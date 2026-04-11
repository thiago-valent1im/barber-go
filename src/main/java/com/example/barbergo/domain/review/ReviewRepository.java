package com.example.barbergo.domain.review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {
    Review save(Review review);
    Optional<Review> findByUserIdAndBarberId(UUID userId, UUID barberId);
    List<Review> findByUserId(UUID userId);
    List<Review> findByBarberId(UUID barberId);
}
