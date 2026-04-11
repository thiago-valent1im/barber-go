package com.example.barbergo.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.barbergo.application.review.GetBarberReviewHistoryUseCase;
import com.example.barbergo.application.review.GetUserReviewHistoryUseCase;
import com.example.barbergo.application.review.SaveReviewUseCase;
import com.example.barbergo.application.review.dtos.SaveReviewRequest;
import com.example.barbergo.domain.review.Review;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ReviewController {
    
    private final SaveReviewUseCase saveReviewUseCase;
    private final GetBarberReviewHistoryUseCase getBarberReviewHistoryUseCase;
    private final GetUserReviewHistoryUseCase getUserReviewHistoryUseCase;

    public ReviewController(
            SaveReviewUseCase saveReviewUseCase, 
            GetBarberReviewHistoryUseCase getBarberReviewHistoryUseCase, 
            GetUserReviewHistoryUseCase getUserReviewHistoryUseCase) {
        this.saveReviewUseCase = saveReviewUseCase;
        this.getBarberReviewHistoryUseCase = getBarberReviewHistoryUseCase;
        this.getUserReviewHistoryUseCase = getUserReviewHistoryUseCase;
    }

    @GetMapping("/barbers/me/reviews")
    public ResponseEntity<List<Review>> getBarberReviewHistoryByToken(JwtAuthenticationToken token) {
        try {
            UUID barberId = UUID.fromString(token.getName());
            return ResponseEntity.status(HttpStatus.OK).body(getBarberReviewHistoryUseCase.execute(barberId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/barbers/{barberId}/reviews")
    public ResponseEntity<List<Review>> getBarberReviewHistoryById(@PathVariable UUID barberId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getBarberReviewHistoryUseCase.execute(barberId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/me/reviews")
    public ResponseEntity<List<Review>> getUserReviewHistoryByToken(JwtAuthenticationToken token) {
        try {
            UUID userId = UUID.fromString(token.getName());
            return ResponseEntity.status(HttpStatus.OK).body(getUserReviewHistoryUseCase.execute(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/{userId}/reviews")
    public ResponseEntity<List<Review>> getUserReviewHistoryById(@PathVariable UUID userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getUserReviewHistoryUseCase.execute(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> saveReview(@RequestBody SaveReviewRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(saveReviewUseCase.execute(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
}
