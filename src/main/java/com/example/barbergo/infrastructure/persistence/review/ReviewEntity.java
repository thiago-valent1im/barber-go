package com.example.barbergo.infrastructure.persistence.review;

import java.util.UUID;

import com.example.barbergo.domain.review.Review;
import com.example.barbergo.infrastructure.persistence.barber.BarberEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_reviews")
public class ReviewEntity {

    @Id
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "barber_id")
    private BarberEntity barber;

    private double rating;
    private String comment;

    public Review toDomain() {
        return new Review(id, userId, barber.toDomain(), rating, comment);
    }

    public static ReviewEntity fromDomain(Review review) {
        return new ReviewEntity(review.getId(), review.getUserId(), BarberEntity.fromDomain(review.getBarber()), review.getRating(), review.getComment());
    }
}
