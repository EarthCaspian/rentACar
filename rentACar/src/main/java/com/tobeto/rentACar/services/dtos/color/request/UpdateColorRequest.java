package com.tobeto.rentACar.services.dtos.color.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {
    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;

    @NotBlank
    @Length(min = 2, message = "Color name cannot be less than 2 characters!")
    private String name;

    @NotBlank
    @Length(min = 7, max = 7, message = "Color code must be exactly 7 characters, including '#' symbol!")
    private String code;

}
