package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
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
@RequestMapping("api/cars")
@AllArgsConstructor
@CrossOrigin
public class CarsController {
    private final CarService carService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddCarRequest request){
        return carService.add(request);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateCarRequest request){
       return carService.update(request);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCarRequest request){
        return carService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllCarsResponse> getAll(){
       return carService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetCarByIdResponse getById(@PathVariable int id){
        return carService.getById(id);
    }
}
