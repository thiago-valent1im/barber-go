package com.example.barbergo.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.barbergo.application.appointment.CancelAppointmentUseCase;
import com.example.barbergo.application.appointment.CreateAppointmentUseCase;
import com.example.barbergo.application.appointment.GetAppointmentsByBarberUseCase;
import com.example.barbergo.application.appointment.GetAppointmentsByUserUseCase;
import com.example.barbergo.application.appointment.GetTimeBlocksUseCase;
import com.example.barbergo.application.appointment.RescheduleAppointmentUseCase;
import com.example.barbergo.application.appointment.dtos.CreateAppointmentRequest;
import com.example.barbergo.application.appointment.dtos.RescheduleAppointmentRequest;
import com.example.barbergo.domain.appointment.Appointment;
import com.example.barbergo.domain.appointment.TimeBlock;

@RestController
public class AppointmentController {
    
    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final GetAppointmentsByUserUseCase getAppointmentsByUserUseCase;
    private final GetAppointmentsByBarberUseCase getAppointmentsByBarberUseCase;
    private final RescheduleAppointmentUseCase rescheduleAppointmentUseCase;
    private final GetTimeBlocksUseCase getTimeBlocksUseCase;
    private final CancelAppointmentUseCase cancelAppointmentUseCase;

    public AppointmentController(
            CreateAppointmentUseCase createAppointmentUseCase,
            GetAppointmentsByUserUseCase getAppointmentsByUserUseCase,
            GetAppointmentsByBarberUseCase getAppointmentsByBarberUseCase,
            RescheduleAppointmentUseCase rescheduleAppointmentUseCase,
            GetTimeBlocksUseCase getTimeBlocksUseCase,
            CancelAppointmentUseCase cancelAppointmentUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.getAppointmentsByUserUseCase = getAppointmentsByUserUseCase;
        this.getAppointmentsByBarberUseCase = getAppointmentsByBarberUseCase;
        this.rescheduleAppointmentUseCase = rescheduleAppointmentUseCase;
        this.getTimeBlocksUseCase = getTimeBlocksUseCase;
        this.cancelAppointmentUseCase = cancelAppointmentUseCase;
    }

    @GetMapping("/time-blocks")
    public ResponseEntity<List<TimeBlock>> getTimeBlocks(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getTimeBlocksUseCase.execute(start, end));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/me/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserToken(JwtAuthenticationToken token) {
        try {
            UUID id = UUID.fromString(token.getName());
            return ResponseEntity.status(HttpStatus.OK).body(getAppointmentsByUserUseCase.execute(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users/{id}/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getAppointmentsByUserUseCase.execute(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/barbers/me/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByBarberToken(JwtAuthenticationToken token) {
        try {
            UUID id = UUID.fromString(token.getName());
            return ResponseEntity.status(HttpStatus.OK).body(getAppointmentsByBarberUseCase.execute(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/barbers/{id}/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsByBarberId(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getAppointmentsByBarberUseCase.execute(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/appointments")
    public ResponseEntity<Appointment> reschedule(@RequestBody RescheduleAppointmentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rescheduleAppointmentUseCase.execute(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> create(@RequestBody CreateAppointmentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createAppointmentUseCase.execute(request));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            cancelAppointmentUseCase.execute(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
