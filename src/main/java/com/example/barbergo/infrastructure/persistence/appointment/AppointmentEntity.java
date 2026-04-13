package com.example.barbergo.infrastructure.persistence.appointment;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.infrastructure.persistence.haircut.HaircutEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tb_appointments")
public class AppointmentEntity {
    
    @Id
    private UUID id;
    private UUID userId;
    private Integer duration;
    private Double total;

    @ManyToMany
    @JoinTable(name = "tb_appointment_haircuts",
        joinColumns = @JoinColumn(name = "appointment_id"),
        inverseJoinColumns = @JoinColumn(name = "haircut_id"))
    private Set<HaircutEntity> haircuts;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TimeBlockEntity time;

    public Appointment toDomain() {
        return new Appointment(id, userId, duration, total, time.toDomain(), haircuts.stream().map(HaircutEntity::toDomain).toList());
    }

    public static AppointmentEntity fromDomain(Appointment appointment) {
        AppointmentEntity entity = new AppointmentEntity(
            appointment.getId(),
            appointment.getUserId(),
            appointment.getDuration(),
            appointment.getTotal(),
            appointment.getHaircuts().stream().map(HaircutEntity::fromDomain).collect(Collectors.toSet()),
            TimeBlockEntity.fromDomain(appointment.getTime())    
        );
        return entity;
    }
}
