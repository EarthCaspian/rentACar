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
	@Length(min = 7, max = 7, message = "Color code must be exactly 7 characters, including '#' symbol!")
	private String code;
}
