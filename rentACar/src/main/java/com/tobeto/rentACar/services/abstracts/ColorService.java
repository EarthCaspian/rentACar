package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;

public interface ColorService {
    Color getById(int id);
    public void add(AddColorRequest request);
}
