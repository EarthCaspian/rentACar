package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerByIdResponse;

import java.util.List;

public interface CustomerService {

    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    List<GetAllCustomerResponse> getAll();
    GetCustomerByIdResponse getById(int id);

}
