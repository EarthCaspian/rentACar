package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

	public boolean existsColorByName(String name);
}
