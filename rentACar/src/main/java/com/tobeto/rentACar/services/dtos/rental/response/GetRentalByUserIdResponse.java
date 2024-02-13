package com.tobeto.rentACar.services.dtos.rental.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalByUserIdResponse {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private String carPlate;
    private String username;
    private String userId;
}
