package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalsResponse {

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;

    private double totalPrice;

    private GetAllUsersResponse user;

    private GetAllCarsResponse car;
}
