package com.tobeto.rentACar.services.dtos.color.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllColorsResponse {
    private String name;
    private String code;
}
