package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentACar.services.dtos.model.request.AddModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.DeleteModelRequest;
import com.tobeto.rentACar.services.dtos.model.request.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.model.response.GetAllModelsResponse;
import com.tobeto.rentACar.services.dtos.model.response.GetModelByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
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

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteModelRequest request) {
        return modelService.delete(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddModelRequest request) {
        return modelService.add(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateModelRequest request) {
        return modelService.update(request);
    }

}
