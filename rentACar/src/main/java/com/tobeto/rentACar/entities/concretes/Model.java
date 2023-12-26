package com.tobeto.rentACar.entities.concretes;


import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Car;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "models")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


}
