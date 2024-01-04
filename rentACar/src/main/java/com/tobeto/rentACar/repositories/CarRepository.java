package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarByPlate(String plate);
    boolean existsCarById(int carId);

   @Query("select new com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse" +
           "(" +
           "c.modelYear, c.plate, c.minFindeksRate, c.kilometer, c.dailyPrice, c.imagePath," +
           "new com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse(m.name," +
           "new com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse(b.id, b.name, b.logoPath)), " +
           "new com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse(co.id,co.name, co.code)" +
           ") " +
           "from Car c " +
           "inner join c.model m " +
           "inner join c.color co " +
           "inner join m.brand b")
   List<GetAllCarsResponse> getAll();

}
