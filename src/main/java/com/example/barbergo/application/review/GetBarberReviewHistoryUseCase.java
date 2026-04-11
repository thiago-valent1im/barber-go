package com.example.barbergo.application.review;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.review.Review;
import com.example.barbergo.domain.review.ReviewRepository;

@Service
public class GetBarberReviewHistoryUseCase {
    
    private final ReviewRepository reviewRepository;
    
    public GetBarberReviewHistoryUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> execute(UUID barberId) {
        return reviewRepository.findByBarberId(barberId);
    }
}
