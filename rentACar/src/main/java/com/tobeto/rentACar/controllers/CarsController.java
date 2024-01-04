package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCarRequest request){
        carService.delete(request);
    }

    @GetMapping
    public List<GetAllCarsResponse> getAll(){
       return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarByIdResponse getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }
}
