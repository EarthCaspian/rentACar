package com.tobeto.rentACar.services.dtos.brand.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @NotNull
    private int id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Cannot contain numbers or special characters.")
    @Length(min = 2, message = "Name length should be at least 2 characters long.")
    private String name;

    @NotBlank
    private String logoPath;

}
