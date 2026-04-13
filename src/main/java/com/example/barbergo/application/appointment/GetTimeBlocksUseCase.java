package com.example.barbergo.application.appointment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.domain.appointment.TimeBlock;
import com.example.barbergo.domain.appointment.TimeBlockRepository;

@Service
public class GetTimeBlocksUseCase {

    private final TimeBlockRepository timeBlockRepository;

    public GetTimeBlocksUseCase(TimeBlockRepository timeBlockRepository) {
        this.timeBlockRepository = timeBlockRepository;
    }

    public List<TimeBlock> execute(LocalDateTime start, LocalDateTime end) {
        return timeBlockRepository.findAllByTimeRange(start, end);
    }
}
