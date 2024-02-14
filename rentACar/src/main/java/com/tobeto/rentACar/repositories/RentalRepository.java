package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {


    List<Rental> findByUserId(int userId);

}
