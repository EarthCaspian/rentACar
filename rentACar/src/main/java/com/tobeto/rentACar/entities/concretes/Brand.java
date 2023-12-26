package com.tobeto.rentACar.entities.concretes;


import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name="logo_path")
    private String logoPath;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Model> models;
}
