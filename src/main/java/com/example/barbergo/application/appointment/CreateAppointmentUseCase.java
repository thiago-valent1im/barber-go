package com.example.barbergo.application.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbergo.application.appointment.dtos.CreateAppointmentRequest;
import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.domain.appointment.AppointmentRepository;
import com.example.barbergo.domain.appointment.TimeBlockRepository;
import com.example.barbergo.domain.haircut.Haircut;
import com.example.barbergo.domain.haircut.HaircutRepository;

@Service
public class CreateAppointmentUseCase {
    
    private final AppointmentRepository appointmentRepository;
    private final HaircutRepository haircutRepository;
    private final TimeBlockRepository timeBlockRepository;

    public CreateAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            HaircutRepository haircutRepository, 
            TimeBlockRepository timeBlockRepository) {
        this.appointmentRepository = appointmentRepository;
        this.haircutRepository = haircutRepository;
        this.timeBlockRepository = timeBlockRepository;
    }

    public Appointment execute(CreateAppointmentRequest request) {
        List<Haircut> haircuts = haircutRepository.findAllById(request.haircuts());

        Appointment appointment = Appointment.create(request.userId(), request.barberId(), request.start(),haircuts);

        if (timeBlockRepository.existsOverlapping(appointment.getTime().getStart(), appointment.getTime().getEnd(), request.barberId()))
            throw new IllegalStateException("Time is not available");
            
        return appointmentRepository.save(appointment);
    }
}
