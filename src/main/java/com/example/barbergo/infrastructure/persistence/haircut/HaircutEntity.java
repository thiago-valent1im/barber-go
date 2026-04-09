package com.example.barbergo.infrastructure.persistence.haircut;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.example.barbergo.domain.haircut.Haircut;

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
@Table(name = "tb_haircuts")
public class HaircutEntity {

    @Id
    private UUID id;
    private String name;
    private String description;
    private Integer duration;
    private Double price;

    public Haircut toDomain() {
        return new Haircut(id, name, description, duration, price);
    }

    public static HaircutEntity fromDomain(Haircut haircut) {
        return new HaircutEntity(haircut.getId(), haircut.getName(), haircut.getDescription(), haircut.getDuration(),
                haircut.getPrice());
    }
}
