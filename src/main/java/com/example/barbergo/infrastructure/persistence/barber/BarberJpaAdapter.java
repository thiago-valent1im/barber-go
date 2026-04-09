package com.example.barbergo.infrastructure.persistence.barber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.barber.Barber;
import com.example.barbergo.domain.barber.BarberRepository;

@Repository
public class BarberJpaAdapter implements BarberRepository {

    private final BarberJpa barberJpa;

    public BarberJpaAdapter(BarberJpa barberJpa) {
        this.barberJpa = barberJpa;
    }

    @Override
    public Barber save(Barber barber) {
        return barberJpa.save(BarberEntity.fromDomain(barber)).toDomain();   
    }

    @Override
    public void delete(Barber user) {
        barberJpa.delete(BarberEntity.fromDomain(user));
    }

    @Override
    public Optional<Barber> findById(UUID id) {
        return barberJpa.findById(id).map(BarberEntity::toDomain);
    }

    @Override
    public List<Barber> findAll() {
        return barberJpa.findAll().stream().map(BarberEntity::toDomain).toList();
    }
    
}
