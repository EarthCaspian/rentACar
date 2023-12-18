package com.tobeto.rentACar.services.dtos.model.request;


import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {

    @NotBlank
    @Length(min = 2, message = "Name length should be at least 2 characters long.")
    private String name;

    @NotNull
    private int brandId;
}
