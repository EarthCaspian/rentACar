package com.tobeto.rentACar.services.dtos.brand.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBrandByIdResponse {
    private int id;
    private String name;
}
