package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class GetAllRentalResponse {

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private double totalPrice;
}
