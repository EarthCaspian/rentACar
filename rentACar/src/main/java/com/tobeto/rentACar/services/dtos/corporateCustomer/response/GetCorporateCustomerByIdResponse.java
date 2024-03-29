package com.tobeto.rentACar.services.dtos.corporateCustomer.response;

import com.tobeto.rentACar.services.dtos.user.response.GetAllUsersResponse;
import com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorporateCustomerByIdResponse {
	private int id;
	private String companyName;
	private String taxNo;
	private GetUserByIdResponse user;
}
