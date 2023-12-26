package com.tobeto.rentACar.entities.concretes;


import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "rentals")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rental extends BaseEntity {

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Column(name="return_date")
    private LocalDate returnDate;

    @Column(name="start_kilometer")
    private Long startKilometer;

    @Column(name="end_kilometer")
    private Long endKilometer;

    @ManyToOne()
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "rental")
    List<Invoice> invoices;
}
