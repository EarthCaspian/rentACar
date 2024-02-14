package com.tobeto.rentACar.services.dtos.rental.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindRentalIdRequest {

    private LocalDate startDate;

    private LocalDate endDate;

    private int carId;

    private int userId;

}
