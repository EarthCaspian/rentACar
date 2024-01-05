package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);

}
