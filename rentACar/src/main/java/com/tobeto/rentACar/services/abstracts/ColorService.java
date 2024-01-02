package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;

import java.util.List;

public interface ColorService {
    GetColorByIdResponse getByIdDTO(int id);
    List<GetAllColorsResponse> getAll();
    void add(AddColorRequest request);
    void update(UpdateColorRequest request);
    void delete(int id);
}
