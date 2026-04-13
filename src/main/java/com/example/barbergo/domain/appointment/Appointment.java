package com.example.barbergo.domain.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.example.barbergo.domain.haircut.Haircut;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Appointment {
    
    private UUID id;
    private UUID userId;
    private Integer duration;
    private Double total;
    private TimeBlock time;
    private List<Haircut> haircuts;

    public Appointment(UUID id, UUID userId, List<Haircut> haircuts) {
        this.id = id;
        this.userId = userId;
        this.haircuts = haircuts;
        this.duration = calcDuration();
        this.total = calcTotal();
    }

    public static Appointment create(UUID userId, UUID barberId, LocalDateTime start, List<Haircut> haircuts) {
        if (userId == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }
        
        if (barberId == null) {
            throw new IllegalArgumentException("Barber id cannot be null");
        }

        if (start == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        
        if (haircuts == null || haircuts.isEmpty()) {
            throw new IllegalArgumentException("Haircuts cannot be null or empty");
        }

        Appointment appointment = new Appointment(UUID.randomUUID(), userId, haircuts);
        appointment.schedule(barberId, start);
        return appointment;
    }

    public int calcDuration() {
        return haircuts.stream().mapToInt(Haircut::getDuration).sum();
    }

    private double calcTotal() {
        return haircuts.stream().mapToDouble(Haircut::getPrice).sum();
    }

    public void schedule(UUID barberId, LocalDateTime start) {
        this.time = TimeBlock.create(barberId, start, start.plusMinutes(duration));
    }
}
