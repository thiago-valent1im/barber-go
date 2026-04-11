package com.example.barbergo.infrastructure.persistence.review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.review.Review;
import com.example.barbergo.domain.review.ReviewRepository;

@Repository
public class ReviewJpaAdapter implements ReviewRepository {

    private final ReviewJpa reviewJpa;

    public ReviewJpaAdapter(ReviewJpa reviewJpa) {
        this.reviewJpa = reviewJpa;
    }

    @Override
    public Review save(Review review) {
        return reviewJpa.save(ReviewEntity.fromDomain(review)).toDomain();
    }

    @Override
    public Optional<Review> findByUserIdAndBarberId(UUID userId, UUID barberId) {
        return reviewJpa.findByUserIdAndBarberId(userId, barberId).map(ReviewEntity::toDomain);
    }

    @Override
    public List<Review> findByUserId(UUID userId) {
        return reviewJpa.findByUserId(userId).stream().map(ReviewEntity::toDomain).toList();
    }

    @Override
    public List<Review> findByBarberId(UUID barberId) {
        return reviewJpa.findByBarberId(barberId).stream().map(ReviewEntity::toDomain).toList();
    }
    
}
