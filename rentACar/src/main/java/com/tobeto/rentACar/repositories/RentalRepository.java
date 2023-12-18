package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    //List<GetAllRentalResponse> getAll();
}
