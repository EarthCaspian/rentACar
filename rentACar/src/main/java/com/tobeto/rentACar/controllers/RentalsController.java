package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@AllArgsConstructor
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddRentalRequest request){
        rentalService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest request){
        rentalService.update(request);
    }

    @DeleteMapping("/delete")
    public  void delete(@RequestBody DeleteRentalRequest request){
        rentalService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalsResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetRentalByIdResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }
}
