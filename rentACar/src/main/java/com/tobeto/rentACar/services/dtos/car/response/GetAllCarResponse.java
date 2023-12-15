package com.tobeto.rentACar.services.dtos.car.response;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class GetAllCarResponse {
    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;
    private GetModelByIdResponse model;
    private GetColorByIdResponse color;
}
