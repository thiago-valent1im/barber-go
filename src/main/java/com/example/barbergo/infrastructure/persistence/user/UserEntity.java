package com.example.barbergo.infrastructure.persistence.user;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.barbergo.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_users")
public class UserEntity implements UserDetails {
    
    @Id
    @Column(name = "user_id")
    private UUID userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    public User toDomain() {
        return new User(userId, name, email, password, role);
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return userId.toString();
    }
}
