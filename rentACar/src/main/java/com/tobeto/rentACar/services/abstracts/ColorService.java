package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;

import java.util.List;

public interface ColorService {
    GetColorByIdResponse getById(int id);
    List<GetAllColorsResponse> getAll();
    Result add(AddColorRequest request);
    Result update(UpdateColorRequest request);
    Result delete(DeleteColorRequest request);
}
