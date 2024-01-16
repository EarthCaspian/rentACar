package com.tobeto.rentACar.core.utilities.exceptions.globalexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;  // Ekledik: Zaman damgasını eklemek için

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {

    private String message;
    private String errorCode;
    private LocalDateTime timestamp;

    public ProblemDetails(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }
}
