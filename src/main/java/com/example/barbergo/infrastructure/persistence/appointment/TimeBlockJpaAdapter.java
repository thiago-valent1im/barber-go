package com.example.barbergo.infrastructure.persistence.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.appointment.TimeBlock;
import com.example.barbergo.domain.appointment.TimeBlockRepository;

@Repository
public class TimeBlockJpaAdapter implements TimeBlockRepository {

    private final TimeBlockJpa timeBlockJpa;

    public TimeBlockJpaAdapter(TimeBlockJpa timeBlockJpa) {
        this.timeBlockJpa = timeBlockJpa;
    }

    @Override
    public List<TimeBlock> findAllByTimeRange(LocalDateTime start, LocalDateTime end) {
        return timeBlockJpa.findAllByTimeRange(start, end).stream().map(TimeBlockEntity::toDomain).toList();
    }

    @Override
    public boolean existsOverlapping(LocalDateTime start, LocalDateTime end, UUID barberId) {
        return timeBlockJpa.existsOverlapping(barberId, start, end);
    }

    @Override
    public boolean existsOverlapping(LocalDateTime start, LocalDateTime end, UUID barberId, UUID timeBlockId) {
        return timeBlockJpa.existsOverlapping(barberId,start, end, timeBlockId);
    }
    
}
