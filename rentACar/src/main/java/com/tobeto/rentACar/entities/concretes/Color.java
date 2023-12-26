package com.tobeto.rentACar.entities.concretes;


import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import com.tobeto.rentACar.entities.concretes.Car;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "colors")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Color extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name="code")
    private String code;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
