package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Rental;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query("SELECT new com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse" +
            "(" +
            "r.startDate, r.endDate, r.returnDate, r.startKilometer, r.endKilometer, r.totalPrice," +
            " new com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse(c.id, c.plate," +
            " new com.tobeto.rentACar.services.dtos.user.response.GetUserByIdResponse(u.id))" +
            ") " +
            "FROM Rental r " +
            "INNER JOIN r.car c " +
            "INNER JOIN r.user u")
    List<GetAllRentalsResponse> getAll();
}
