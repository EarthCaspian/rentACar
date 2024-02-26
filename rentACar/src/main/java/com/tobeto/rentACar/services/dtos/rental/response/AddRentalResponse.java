package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.core.utilities.results.Result;
import lombok.Data;

@Data
public class AddRentalResponse {
	private Integer id;
	private Result result;
}
