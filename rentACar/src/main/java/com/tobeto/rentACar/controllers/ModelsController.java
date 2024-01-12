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
@CrossOrigin
public class ModelsController {


    private final ModelService modelService;


    @GetMapping("/getAllName")
    List<String> getAllName() {
         return modelService.getAllName();
    }

    @GetMapping("/getAll")
    List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetModelByIdResponse getById(@PathVariable int id) {
        return modelService.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        modelService.delete(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddModelRequest request) {
        modelService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateModelRequest request) {
        modelService.update(request);
    }

}
