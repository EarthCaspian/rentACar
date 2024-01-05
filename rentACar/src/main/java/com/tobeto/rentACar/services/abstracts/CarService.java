package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarByIdResponse getById(int id);
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);
    boolean existsCarById(int carId);



}
