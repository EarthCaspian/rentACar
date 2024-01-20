package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomersResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerByIdResponse;

import java.util.List;

public interface CustomerService {

    Result add(AddCustomerRequest request);
    Result update(UpdateCustomerRequest request);
    Result delete(DeleteCustomerRequest request);
    List<GetAllCustomersResponse> getAll();
    GetCustomerByIdResponse getById(int id);

}
