package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public GetBrandByIdResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        return modelMapperService.forResponse().map(brand, GetBrandByIdResponse.class);
    }

    @Override
    public List<String> getAllName() {
        return brandRepository.findAll().stream()
                .map(Brand::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands
                .stream()
                .map(brand -> this.modelMapperService
                        .forResponse()
                        .map(brand, GetAllBrandsResponse.class))
                .toList();
    }


    @Override
    public void add(AddBrandRequest request) {
        if (brandRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a brand with this name.");

        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        if (brandRepository.existsByName(request.getName()))
            throw new RuntimeException("There's already a brand with this name.");

        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
