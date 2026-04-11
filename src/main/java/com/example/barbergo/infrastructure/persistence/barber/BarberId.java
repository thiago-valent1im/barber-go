package com.example.barbergo.infrastructure.persistence.barber;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class BarberId {
    private UUID userId;
    private Double commission;
}
