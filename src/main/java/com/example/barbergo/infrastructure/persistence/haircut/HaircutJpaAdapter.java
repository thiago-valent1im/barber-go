package com.example.barbergo.infrastructure.persistence.haircut;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.haircut.Haircut;
import com.example.barbergo.domain.haircut.HaircutRepository;

@Repository
public class HaircutJpaAdapter implements HaircutRepository{
    
    private final HaircutJpa haircutJpa;

    public HaircutJpaAdapter(HaircutJpa haircutJpa) {
        this.haircutJpa = haircutJpa;
    }

    @Override
    public Haircut save(Haircut haircut) {
        haircutJpa.save(HaircutEntity.fromDomain(haircut));
        return haircut;
    }

    @Override
    public void deleteById(UUID id) {
        haircutJpa.deleteById(id);
    }

    @Override
    public Optional<Haircut> findById(UUID id) {
        return haircutJpa.findById(id).map(HaircutEntity::toDomain);
    }

    @Override
    public List<Haircut> findAll() {
        return haircutJpa.findAll().stream().map(HaircutEntity::toDomain).toList();
    }
}
