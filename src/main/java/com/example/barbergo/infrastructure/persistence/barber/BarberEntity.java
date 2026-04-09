package com.example.barbergo.infrastructure.persistence.barber;

import java.util.UUID;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.infrastructure.persistence.user.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_barbers")
public class BarberEntity {
    
    @Id
    @Column(name = "barber_id")
    private UUID barberId;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private UserEntity user;
    private Double commission;
    private Double rating;

    public Barber toDomain() {
        return new Barber(barberId, user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), commission, rating);
    }

    public static BarberEntity fromDomain(Barber barber) {
        return new BarberEntity(barber.getBarberId(), UserEntity.fromDomain(barber), barber.getCommission(), barber.getRating());
    }
}
