package com.tobeto.rentACar.services.dtos.corporateCustomer.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateCustomerRequest {

	@NotNull(message = "Company name cannot be null!")
	private String companyName;

	@NotNull(message = "Tax number cannot be null!")
	@Length(min = 9, message = "Tax number must contain at least 9 characters!")
	@Pattern(regexp = "^[0-9\\s]*$", message = "Tax number should consist of numbers only.")
	private String taxNo;

	@NotNull(message = "The user must be specified!")
	//@Positive(message = "The assigned value must not assume a negative numerical value!")
	private int userId;
}
