package com.tobeto.rentACar.services.dtos.rental.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int id;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private LocalDate returnDate;

    @NotNull
    private int endKilometer;

    @NotNull
    private double totalPrice;

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int carId;

    @NotNull
    @Positive(message = "The assigned value must not assume a negative numerical value!")
    private int userId;
}
