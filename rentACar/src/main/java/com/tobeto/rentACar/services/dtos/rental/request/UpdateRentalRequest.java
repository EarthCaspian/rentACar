package com.tobeto.rentACar.services.dtos.rental.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateRentalRequest {

    private int id;

    private LocalDate startDate;


    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private int carId;

    private int userId;
}
