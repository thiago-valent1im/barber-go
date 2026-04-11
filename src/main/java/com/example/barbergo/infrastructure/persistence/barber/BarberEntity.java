package com.example.barbergo.infrastructure.persistence.barber;

import java.util.UUID;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.infrastructure.persistence.user.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_barbers")
public class BarberEntity {
    
    @Id
    private UUID id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Double commission;
    private Double rating;
    private int reviewsCount;

    public Barber toDomain() {
        return new Barber(user.getId(), user.getName(), user.getEmail(), user.getPassword(), commission, rating, reviewsCount);
    }

    public static BarberEntity fromDomain(Barber barber) {
        return new BarberEntity(barber.getId(), UserEntity.fromDomain(barber), barber.getCommission(),barber.getRating(), barber.getReviewsCount());
    }
}
