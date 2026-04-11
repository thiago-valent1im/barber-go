package com.example.barbergo.domain.barber;

import java.util.UUID;

import com.example.barbergo.domain.review.Review;
import com.example.barbergo.domain.user.User;

import lombok.Getter;

@Getter
public class Barber extends User {
    private Double commission;
    private Double rating;
    private int reviewsCount;

    public Barber(UUID id, String name, String email, String password, Double commission, Double rating, int reviewsCount) {
        super(id, name, email, password, "BARBER");

        if (commission < 0 || commission > 1) {
            throw new IllegalArgumentException("Commission must be between 0 and 1");
        }

        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }

        if (reviewsCount < 0) {
            throw new IllegalArgumentException("Reviews count must be greater than 0");
        }

        this.commission = commission;
        this.rating = rating;
        this.reviewsCount = reviewsCount;
    }

    public void addReview(Review review) {
        reviewsCount++;
        rating = (rating * (reviewsCount - 1) + review.getRating()) / reviewsCount;
    }

    public void updateReview(Review oldReview, Review newReview) {
        rating = (rating * reviewsCount + newReview.getRating() - oldReview.getRating()) / reviewsCount;
    }
}
