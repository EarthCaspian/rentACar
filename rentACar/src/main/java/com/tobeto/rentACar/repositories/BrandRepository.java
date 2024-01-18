package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsById(int id);
    boolean existsByName(String name);

}
