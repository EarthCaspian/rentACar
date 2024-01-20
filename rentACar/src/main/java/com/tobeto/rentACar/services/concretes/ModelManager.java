package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Brand;
import com.tobeto.rentACar.entities.concretes.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import com.tobeto.rentACar.services.rules.BrandBusinessRule;
import com.tobeto.rentACar.services.rules.ModelBusinessRule;
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
    private final ModelBusinessRule modelBusinessRule;
    private final BrandBusinessRule brandBusinessRule;
    private MessageService messageService;

    @Override
    public GetModelByIdResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Model.getModelNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(model, GetModelByIdResponse.class);
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
    public Result add(AddModelRequest request) {
        modelBusinessRule.existsModelByName(request.getName());

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        model.setId(null);

        GetBrandByIdResponse brandResponse = brandService.getById(request.getBrandId());

        brandBusinessRule.existsBrandById(request.getBrandId());

        Brand brand = this.modelMapperService.forRequest().map(brandResponse, Brand.class);
        model.setBrand(brand);
        modelRepository.save(model);

        return new SuccessResult(messageService.getMessage(Messages.Model.modelAddSuccess));


    }

    @Override
    public Result update(UpdateModelRequest request) {

        modelBusinessRule.existsModelByName(request.getName());

        Model model = this.modelMapperService.forRequest().map(request,Model.class);
        GetBrandByIdResponse brandResponse = brandService.getById(request.getBrandId());

        brandBusinessRule.existsBrandById(request.getBrandId());

        Brand brand = this.modelMapperService.forResponse().map(brandResponse, Brand.class);
        model.setBrand(brand);
        modelRepository.save(model);

        return new SuccessResult(messageService.getMessage(Messages.Model.modelUpdateSuccess));

    }

    @Override
    public Result delete(DeleteModelRequest request) {
        modelBusinessRule.existsModelById(request.getId());

        modelRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Model.modelDeleteSuccess));
    }
}
