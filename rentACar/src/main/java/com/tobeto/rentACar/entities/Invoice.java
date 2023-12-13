package com.tobeto.rentACar.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Getter
@Setter
public class Invoice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "rentalId")
    private Rental rental;

    @Column(name = "createDate")
    private LocalDate createDate;

}
