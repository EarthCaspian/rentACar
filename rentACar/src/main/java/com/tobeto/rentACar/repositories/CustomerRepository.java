package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
