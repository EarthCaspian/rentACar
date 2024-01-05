package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.corporateCustomer.request.AddCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.DeleteCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.UpdateCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetAllCorporateCustomerResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetCorporateCustomerByIdResponse;

import java.util.List;

public interface CorporateCustomerService {
	void add(AddCorporateCustomerRequest request);
	void update(UpdateCorporateCustomerRequest request);
	void delete(DeleteCorporateCustomerRequest request);
	List<GetAllCorporateCustomerResponse> getAll();
	GetCorporateCustomerByIdResponse getById(int id);
}
