package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByPlate(String plate);

    @Query("select new com.tobeto.rentACar.services.dtos.car.response.GetAllCarResponse" +
            "(" +
            "c.kilometer, c.plate, c.year, c.dailyPrice," +
            "new com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse(m.id, m.name), " +
            "new com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse(co.id, co.name)" +
            ") " +
            "from Car c " +
            "inner join c.model m " +
            "inner join c.color co")
    List<GetAllCarResponse> getAll();

    @Query("select new com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse" +
            "(" +
            "c.id, c.kilometer, c.plate, c.year, c.dailyPrice," +
            "new com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse(m.id, m.name), " +
            "new com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse(co.id, co.name)" +
            ") " +
            "from Car c " +
            "inner join c.model m " +
            "inner join c.color co")
    List<GetCarByIdResponse> getCarById();

    boolean existsCarById(int carId);
}
