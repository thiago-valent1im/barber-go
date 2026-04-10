package com.example.barbergo.domain.haircut;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface HaircutRepository {
    Haircut save(Haircut haircut);
    void deleteById(UUID id);
    Optional<Haircut> findById(UUID id);
    List<Haircut> findAll();
}
