package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;

import java.util.List;

public interface ModelService {
    GetModelByIdResponse getById(int id);
    List<String> getAllName();
    List<GetAllModelsResponse> getAll();
    void add(AddModelRequest request);
    void update (UpdateModelRequest request);
    void delete(int id);
}
