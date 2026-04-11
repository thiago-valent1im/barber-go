package com.example.barbergo.application.review;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.review.dtos.SaveReviewRequest;
import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;
import com.example.barbergo.domain.review.Review;
import com.example.barbergo.domain.review.ReviewRepository;

@Service
public class SaveReviewUseCase {
    
    private final ReviewRepository reviewRepository;
    private final BarberRepository barberRepository;

    public SaveReviewUseCase(ReviewRepository reviewRepository, BarberRepository barberRepository) {
        this.reviewRepository = reviewRepository;
        this.barberRepository = barberRepository;
    }

    public Review execute(SaveReviewRequest request) {
        Barber barber = barberRepository
                .findById(request.barberId())
                .orElseThrow(() -> new IllegalArgumentException("Barber not found"));

        Review review = reviewRepository
                .findByUserIdAndBarberId(request.userId(), request.barberId())
                .map(r -> r.update(request.rating(), request.comment()))
                .orElse(
                    Review.create(
                        UUID.randomUUID(),
                        request.userId(),
                        barber,
                        request.rating(),
                        request.comment()
                    )
                );

        return reviewRepository.save(review);
    }
}
