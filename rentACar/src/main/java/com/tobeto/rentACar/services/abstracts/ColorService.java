package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Color;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ColorService {
    Color getById(int id);
    public void add(AddColorRequest request);
}
