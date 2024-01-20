package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByPlate(String plate);
}
