package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByPlate(String plate);
    boolean existsCarById(int carId);

}
