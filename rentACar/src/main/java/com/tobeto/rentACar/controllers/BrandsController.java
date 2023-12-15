package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {


    BrandService brandService;



    @GetMapping
    public List<String> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getById(@PathVariable int id) {
        return brandService.getByIdDTO(id);
    }

    @DeleteMapping
    public void delete(int id) {
        brandService.delete(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest request) {
        brandService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest request) {
        brandService.update(request);
    }

}
