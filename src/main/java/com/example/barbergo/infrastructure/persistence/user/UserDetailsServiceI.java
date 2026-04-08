package com.example.barbergo.infrastructure.persistence.user;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.barbergo.domain.user.UserRepository;

@Service
public class UserDetailsServiceI implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userRepository.findById(UUID.fromString(id)).map(UserEntity::fromDomain)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
    }
    
}
