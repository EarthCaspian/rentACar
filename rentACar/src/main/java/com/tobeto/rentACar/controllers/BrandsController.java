package com.tobeto.rentACar.controllers;


import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.brand.request.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.DeleteBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.request.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.brand.response.GetAllBrandsResponse;
import com.tobeto.rentACar.services.dtos.brand.response.GetBrandByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteBrandRequest request) {
        return brandService.delete(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddBrandRequest request) {
       return brandService.add(request);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateBrandRequest request) {
       return brandService.update(request);
    }

}
