package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Customer;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select new com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomerResponse" +
            "(c.firstName, c.lastName, c.birthdate, c.internationalId, c.licenceIssueDate) " +
            "from Customer c")
    List<GetAllCustomerResponse> getAll();
}
