package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    boolean existsByName(String name);


}
