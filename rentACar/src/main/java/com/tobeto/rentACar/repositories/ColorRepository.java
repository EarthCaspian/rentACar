package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

	public boolean existsColorByName(String name);
}
