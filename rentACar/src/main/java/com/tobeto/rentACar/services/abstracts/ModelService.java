package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;

import java.util.List;

public interface ModelService {
    GetModelByIdResponse getById(int id);
    List<String> getAllName();
    List<GetAllModelsResponse> getAll();
    Result add(AddModelRequest request);
    Result update (UpdateModelRequest request);
    Result delete(DeleteModelRequest request);
}
