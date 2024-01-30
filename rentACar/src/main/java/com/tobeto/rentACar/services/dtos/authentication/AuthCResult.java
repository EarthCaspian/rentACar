package com.tobeto.rentACar.services.dtos.authentication;

import com.tobeto.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthCResult extends Result {

    private LoginResponse loginResponse;

    public AuthCResult(boolean success, String message, LoginResponse loginResponse) {
        super(success, message);
        this.loginResponse = loginResponse;
    }
}
