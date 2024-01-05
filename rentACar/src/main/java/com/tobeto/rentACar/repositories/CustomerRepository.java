package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomersResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
