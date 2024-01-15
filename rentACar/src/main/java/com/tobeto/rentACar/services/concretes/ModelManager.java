package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final BrandService brandService;

    @Override
    public GetModelByIdResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(model, GetModelByIdResponse.class);
    }

    @Override
    public List<String> getAllName() {

        return modelRepository.findAll().stream()
                .map(Model::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        return models
                .stream()
                .map(model -> this.modelMapperService
                        .forResponse()
                        .map(model, GetAllModelsResponse.class))
                .toList();
    }


    @Override
    public void add(AddModelRequest request) {
        if (modelRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a model with this name.");

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        model.setId(null);

        GetBrandByIdResponse brandResponse = brandService.getById(request.getBrandId());

        if (brandResponse == null) {
            throw new RuntimeException("Brand not found with id: " + request.getBrandId());
        }
        Brand brand = this.modelMapperService.forRequest().map(brandResponse, Brand.class);
        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest request) {
        if (modelRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a model with this name.");

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        GetBrandByIdResponse brandResponse = brandService.getById(request.getBrandId());

        if (brandResponse == null) {
            throw new RuntimeException("Brand not found with id: " + request.getBrandId());
        }

        Brand brand = this.modelMapperService.forResponse().map(brandResponse, Brand.class);
        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}
