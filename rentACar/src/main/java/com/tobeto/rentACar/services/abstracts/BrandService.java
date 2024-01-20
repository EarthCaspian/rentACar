package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;

import java.util.List;

public interface BrandService {
    GetBrandByIdResponse getById(int id);
    List<String> getAllName();
    List<GetAllBrandsResponse> getAll();
    Result add(AddBrandRequest request);
    Result update(UpdateBrandRequest request);
    Result delete(DeleteBrandRequest request);

}
