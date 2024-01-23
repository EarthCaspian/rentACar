package com.tobeto.rentACar.services.dtos.brand.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
    private int id;

    private String name;

    private String logoPath;
}
