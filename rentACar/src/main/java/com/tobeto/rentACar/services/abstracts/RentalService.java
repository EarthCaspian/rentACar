package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.FindRentalIdRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;

import com.tobeto.rentACar.services.dtos.rental.response.GetRentalIdResponse;

import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByUserIdResponse;


import java.util.List;


public interface RentalService {
    Result add(AddRentalRequest request);
    Result update(UpdateRentalRequest request);
    Result delete(DeleteRentalRequest request);
    List<GetAllRentalsResponse> getAll();
    GetRentalByIdResponse getById(int id);

    GetRentalIdResponse getRentalId(FindRentalIdRequest request);


    List<GetRentalByUserIdResponse> getByUserId(int userId);

}
