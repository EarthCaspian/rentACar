package com.tobeto.rentACar.services.dtos.rental.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRentalRequest {

    private LocalDate startDate;

    private LocalDate endDate;

    private int carId;

    private int userId;

}
