package com.tobeto.rentACar.core.utilities.exceptions.globalexceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {

    private Map<String, String> validationErrors;


    public ValidationProblemDetails(String message, String errorCode, Map<String, String> validationErrors) {
        super(message, errorCode);
        this.validationErrors = validationErrors;
    }
}