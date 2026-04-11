package com.example.barbergo.infrastructure.security;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.barbergo.domain.user.UserRepository;
import com.example.barbergo.infrastructure.persistence.user.UserEntity;

@Service
public class UserDetailsServiceI implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(UserEntity::fromDomain)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
    
}
