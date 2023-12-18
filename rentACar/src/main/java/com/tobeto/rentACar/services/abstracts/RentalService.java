package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.car.response.GetAllCarResponse;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalResponse;

import java.util.List;


public interface RentalService {

    void add(AddRentalRequest request);
    void update(UpdateRentalRequest request);
    void delete(DeleteRentalRequest request);

    //List<GetAllRentalResponse> getAll();


}
