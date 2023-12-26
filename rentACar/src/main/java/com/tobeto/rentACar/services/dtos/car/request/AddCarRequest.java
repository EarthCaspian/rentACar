package com.tobeto.rentACar.services.dtos.car.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotNull
    @Positive(message = "The value cannot be negative!")
    private Long kilometer;

    @NotBlank
    @Length(max = 10)
    @Pattern(regexp = "^[0-9A-Z\\s-]*$",
            message = "Only include numbers or capital letters, special characters not allowed")
    private String plate;

    @NotNull
    @Min(value = 2005, message = "Production year must be between 2005 to 2024!")
    @Max(value = 2024, message = "Production year must be between 2005 to 2024!")
    private short modelYear;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private Float dailyPrice;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int modelId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int colorId;

    @NotNull
    private short minFindeksRate;

    @NotBlank
    private String imagePath;

}
