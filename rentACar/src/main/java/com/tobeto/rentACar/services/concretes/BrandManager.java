package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.internationalization.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import com.tobeto.rentACar.services.rules.BrandBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRule brandBusinessRule;
    private MessageService messageService;

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
    public Result add(AddBrandRequest request) {
        brandBusinessRule.existsBrandByName(request.getName());

        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);

        return new SuccessResult(messageService.getMessage(Messages.Brand.brandAddSuccess));
    }

    @Override
    public Result update(UpdateBrandRequest request) {
        brandBusinessRule.existsBrandByName(request.getName());

        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);
        return new SuccessResult(messageService.getMessage(Messages.Brand.brandUpdateSuccess));
    }

    @Override
    public Result delete(DeleteBrandRequest request){

        brandBusinessRule.existsBrandById(request.getId());

        brandRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Brand.brandDeleteSuccess));
    }
}