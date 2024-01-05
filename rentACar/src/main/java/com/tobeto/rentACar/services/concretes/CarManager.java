package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map((car) -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    public GetCarByIdResponse getById(int id) {
        //Checking whether the relevant user exists or not
        Car car = carRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("User not found with ID: " + id));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(car, GetCarByIdResponse.class);
    }

    @Override
    public void add(AddCarRequest request) {

        //The input is converted as compatible with the database
        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));

        //Business Rule
        //Two vehicles cannot be registered with the same license plate
        if (carRepository.existsCarByPlate(request.getPlate())){
            throw  new RuntimeException("Car cannot be registered with the same plate!");
        }

        //Mapping
        Car car = this.modelMapperService.forRequest().map(request, Car.class);

        //Saving
        carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest request) {

        //The input is converted as compatible with the database
        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));

        //Business Rule
        //Two vehicles cannot be registered with the same license plate
        if (carRepository.existsCarByPlate(request.getPlate())){
            throw  new RuntimeException("Car cannot be registered with the same plate!");
        }

        //Mapping
        Car car = this.modelMapperService.forRequest().map(request, Car.class);

        //Updating
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
