package com.tobeto.rentACar.services.dtos.rental.request;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UpdateRentalRequest {

    private int id;

    private LocalDate startDate;


    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private double totalPrice;

    private int carId;

    private int userId;
}
