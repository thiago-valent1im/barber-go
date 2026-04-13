package com.example.barbergo.domain.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface TimeBlockRepository {
   List<TimeBlock> findAllByTimeRange(LocalDateTime start, LocalDateTime end);
   boolean existsOverlapping(LocalDateTime start, LocalDateTime end, UUID barberId);
   boolean existsOverlapping(LocalDateTime start, LocalDateTime end, UUID barberId, UUID timeBlockId);
}

