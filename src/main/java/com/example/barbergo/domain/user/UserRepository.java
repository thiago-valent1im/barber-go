package com.example.barbergo.domain.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User save(User user);
    void delete(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
