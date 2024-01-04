package com.tobeto.rentACar.services.dtos.corporateCustomer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCorporateCustomerResponse {
	private String companyName;
	private String taxNo;
	private String userEmail;
}
