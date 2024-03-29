package com.tobeto.rentACar.services.dtos.model.response;

import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
    private Integer id;

    private String name;

    private GetBrandByIdResponse brand;
}
