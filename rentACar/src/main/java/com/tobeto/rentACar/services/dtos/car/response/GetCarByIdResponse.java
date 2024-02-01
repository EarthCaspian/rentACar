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
    private Integer id;
    private short modelYear;
    private String plate;
    private short minFindeksRate;
    private Long kilometer;
    private Float dailyPrice;
    private String imagePath;
    private GetModelByIdResponse model;
    private GetColorByIdResponse color;
}
