package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;

import java.util.List;

public interface ModelService {
    Model getById(int id);

    GetModelByIdResponse getByIdDTO(int id);
    List<String> getAll();
    void add(AddModelRequest request);
    void update (UpdateModelRequest request);
    void delete(int id);
}
