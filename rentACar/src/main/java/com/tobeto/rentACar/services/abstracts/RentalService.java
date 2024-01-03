package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;

import java.util.List;


public interface RentalService {

    void add(AddRentalRequest request);
    void update(UpdateRentalRequest request);
    void delete(DeleteRentalRequest request);
    List<GetAllRentalsResponse> getAll();
    GetRentalByIdResponse getById(int id);

}
