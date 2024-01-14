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
@CrossOrigin
public class CarsController {
    private final CarService carService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteCarRequest request){
        carService.delete(request);
    }

    @GetMapping("/getall")
    public List<GetAllCarsResponse> getAll(){
       return carService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetCarByIdResponse getById(@PathVariable int id){
        return carService.getById(id);
    }
}
