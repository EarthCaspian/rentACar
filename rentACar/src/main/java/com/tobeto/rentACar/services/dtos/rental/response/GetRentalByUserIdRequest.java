package com.tobeto.rentACar.services.dtos.rental.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalByUserIdRequest {
    private LocalDate startDate;
    private LocalDate returnDate;
    private double totalPrice;
}
