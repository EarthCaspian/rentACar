package com.tobeto.rentACar.entities.concretes;


import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "cars")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car extends BaseEntity {

    @Column(name="model_year")
    private short modelYear;

    @Column(name="plate")
    private String plate;

    @Column(name="min_findeks_rate")
    private short minFindeksRate;

    @Column(name="kilometer")
    private Long kilometer;

    @Column(name="daily_price")
    private Float dailyPrice;

    @Column(name="image_path")
    private String imagePath;

    @ManyToOne()
    @JoinColumn(name="model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
