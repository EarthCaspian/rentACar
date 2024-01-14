package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
@CrossOrigin
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAllName")
    public List<String> getAllName() {
        return brandService.getAllName();
    }

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetBrandByIdResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        brandService.delete(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest request) {
        brandService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateBrandRequest request) {
        brandService.update(request);
    }

}
