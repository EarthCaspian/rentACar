package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.AddCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.DeleteCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.UpdateCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetAllCorporateCustomersResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetCorporateCustomerByIdResponse;

import java.util.List;

public interface CorporateCustomerService {
	Result add(AddCorporateCustomerRequest request);
	Result update(UpdateCorporateCustomerRequest request);
	Result delete(DeleteCorporateCustomerRequest request);
	List<GetAllCorporateCustomersResponse> getAll();
	GetCorporateCustomerByIdResponse getById(int id);
}
