package com.tobeto.rentACar.services.dtos.color.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetColorByIdResponse {
    private String name;
    private String code;
}
