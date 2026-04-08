package com.example.barbergo.infrastructure.persistence.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.barbergo.domain.user.User;
import com.example.barbergo.domain.user.UserRepository;

@Repository
public class UserJpaAdapter implements UserRepository{

    private final UserJpa userJpa;
    
    public UserJpaAdapter(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    @Override
    public User save(User user) {
        userJpa.save(UserEntity.fromDomain(user));
        return user;
    }

    @Override
    public void delete(User user) {
        userJpa.delete(UserEntity.fromDomain(user));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpa.findById(id).map(UserEntity::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpa.findByEmail(email).map(UserEntity::toDomain);
    }

    @Override
    public List<User> findAll() {
        return userJpa.findAll().stream().map(UserEntity::toDomain).toList();
    }
    
}
