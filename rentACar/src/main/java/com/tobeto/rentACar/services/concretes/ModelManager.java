package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
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
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow();
    }

    @Override
    public GetModelByIdResponse getByIdDTO(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(model, GetModelByIdResponse.class);
    }

    @Override
    public List<String> getAll() {
        /*
        return modelRepository.findAll().stream()
                .map(Model::getName)
                .collect(Collectors.toList());

         */
        return null;
    }

    @Override
    public void add(AddModelRequest request) {
        if (modelRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a model with this name.");

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        Brand brand = brandService.getById(request.getBrandId());

        if (brand == null) {
            throw new RuntimeException("Brand not found with id: " + request.getBrandId());
        }

        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest request) {
        if (modelRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a model with this name.");

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        Brand brand = brandService.getById(request.getBrandId());

        if (brand == null) {
            throw new RuntimeException("Brand not found with id: " + request.getBrandId());
        }

        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}
