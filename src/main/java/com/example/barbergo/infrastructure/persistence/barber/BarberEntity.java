package com.example.barbergo.infrastructure.persistence.barber;

import java.util.UUID;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.infrastructure.persistence.user.UserEntity;

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
    private UUID id;
    @OneToOne
    private UserEntity user;
    private Double commission;
    private Double rating;

    public Barber toDomain() {
        return new Barber(id, user.getName(), user.getEmail(), user.getPassword(), commission, rating);
    }

    public static BarberEntity fromDomain(Barber barber) {
        return new BarberEntity(barber.getId(), UserEntity.fromDomain(barber), barber.getCommission(), barber.getRating());
    }
}
