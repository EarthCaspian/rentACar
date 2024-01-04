package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Rental;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {


    @Query("select new com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse" +
            "(" +
            "r.startDate, r.endDate, r.minFindeksRate, r.returnDate, r.startKilometer, r.endKilometer," +
            "new com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse(c.id, c.plate," +
            "new com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse(u.id)), " +
            ") " +
            "from Rental r " +
            "inner join r.car c " +
            "inner join c.color co " +
            "inner join r.user u")
    List<GetAllRentalsResponse> getAll();
}
