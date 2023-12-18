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
    List<GetAllCarResponse> getAll();
    GetCarByIdResponse getCarById(GetCarByIdRequest request);

    Car getById(int id);

    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);
    boolean existsCarById(int carId);



}
