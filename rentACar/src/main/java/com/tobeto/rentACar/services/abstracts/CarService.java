package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.GetCarByIdRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;

import java.util.List;

public interface CarService {
    public List<GetAllCarResponse> getAll();
    public GetCarByIdResponse getCarById(GetCarByIdRequest request);
    public void add(AddCarRequest request);
    public void update(UpdateCarRequest request);
    public void delete(DeleteCarRequest request);

}
