package com.tobeto.rentACar.services.dtos.car.response;

import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByIdResponse {
    private  int id;
    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;
    private GetModelByIdResponse model;
    private GetColorByIdResponse color;
}
