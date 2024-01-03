package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@AllArgsConstructor
public class ModelsController {


    ModelService modelService;


    @GetMapping("getAllName")
    List<String> getAllName() {
         return modelService.getAllName();
    }

    @GetMapping
    List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetModelByIdResponse getById(@PathVariable int id) {
        return modelService.getByIdDTO(id);
    }

    @DeleteMapping
    public void delete(int id) {
        modelService.delete(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddModelRequest request) {
        modelService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateModelRequest request) {
        modelService.update(request);
    }

}