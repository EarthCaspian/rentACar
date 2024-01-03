package com.tobeto.rentACar.services.dtos.color.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddColorRequest {
	@NotBlank
	@Length(min = 2, message = "Color name cannot be less than 2 characters!")
	private String name;

	@NotBlank
	@Length(min = 6, max = 6, message = "Color code must be exactly 6 characters!")
	private String code;
}
