package com.example.barbergo.application.review;

import java.lang.classfile.ClassFile.Option;
import java.util.Optional;
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

        Optional<Review> optionalReview = reviewRepository.findByUserIdAndBarberId(
                request.userId(), request.barberId());
        
        UUID id = optionalReview.map(Review::getId).orElseGet(UUID::randomUUID);
        
        Review review = new Review(
                id, 
                request.userId(), 
                barber, 
                request.rating(), 
                request.comment());

        if (optionalReview.isPresent()) {
            barber.updateReview(optionalReview.get(), review);
        } else {
            barber.addReview(review);
        }

        return reviewRepository.save(review);
    }
}
