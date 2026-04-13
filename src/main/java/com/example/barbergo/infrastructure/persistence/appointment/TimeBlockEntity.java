package com.example.barbergo.infrastructure.persistence.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.barbergo.domain.appointment.TimeBlock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "tb_time_blocks")
public class TimeBlockEntity {
    
    @Id
    private UUID id;
    private UUID barberId;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;

    public TimeBlock toDomain() {
        return new TimeBlock(id, barberId, startTime, endTime);
    }

    public static TimeBlockEntity fromDomain(TimeBlock timeBlock) {
        return new TimeBlockEntity(timeBlock.getId(), timeBlock.getBarberId(), timeBlock.getStart(), timeBlock.getEnd());
    }
}
