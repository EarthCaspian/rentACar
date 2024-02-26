package com.tobeto.rentACar.services.dtos.authentication;

import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
}
