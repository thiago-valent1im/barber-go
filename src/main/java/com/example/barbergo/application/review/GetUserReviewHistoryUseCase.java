package com.example.barbergo.application.review;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.review.Review;
import com.example.barbergo.domain.review.ReviewRepository;

@Service
public class GetUserReviewHistoryUseCase {
    
    private final ReviewRepository reviewRepository;
    
    public GetUserReviewHistoryUseCase(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> execute(UUID userId) {
        return reviewRepository.findByUserId(userId);
    }
}
