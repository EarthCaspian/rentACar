package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.GetCarByIdRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarResponse> getAll() {
        return carRepository.getAll();
    }

    @Override
    public GetCarByIdResponse getCarById(GetCarByIdRequest request) {
        //Finding the relevant object!
        Car car = carRepository.findById(request.getId()).orElseThrow();

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(car, GetCarByIdResponse.class);
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public void add(AddCarRequest request) {
        //Business Rule
        if (carRepository.existsCarByPlate(request.getPlate())){
            throw  new RuntimeException("Car cannot be registered with the same plate!");
        }
        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));
        Car car = this.modelMapperService.forRequest()
                .map(request, Car.class);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        //Business Rule
        if (carRepository.existsCarByPlate(request.getPlate())){
            throw  new RuntimeException("Car cannot be registered with the same plate!");
        }

        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));

        Car car = this.modelMapperService.forRequest()
                .map(request, Car.class);

        carRepository.save(car);
    }

    @Override
    public void delete(DeleteCarRequest request) {
        //Checking the existance of the car
        carRepository.findById(request.getId()).orElseThrow();
        //Delete the car
        carRepository.deleteById(request.getId());
    }

    @Override
    public boolean existsCarById(int carId) {
        return carRepository.existsCarById(carId);
    }


}
