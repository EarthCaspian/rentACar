package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;

import java.util.List;

public interface BrandService {
    GetBrandByIdResponse getByIdDTO(int id);
    Brand getById(int id);
    List<String> getAll();
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(int id);

}
