package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.FindRentalIdRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
@CrossOrigin
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddRentalRequest request){
        return rentalService.add(request);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateRentalRequest request){
        return rentalService.update(request);
    }

    @DeleteMapping("/delete")
    public  Result delete(@RequestBody @Valid DeleteRentalRequest request){
        return rentalService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalsResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetRentalByIdResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

    @GetMapping("/getRentalId")
    public GetRentalIdResponse getRentalId(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate,
            @RequestParam("carId") int carId,
            @RequestParam("userId") int userId) {

        // Parse the date portion of the date-time strings
        LocalDate parsedStartDate = LocalDate.parse(startDate.substring(0, 10)); // Extract the date part
        LocalDate parsedEndDate = LocalDate.parse(endDate.substring(0, 10)); // Extract the date part

        FindRentalIdRequest request = new FindRentalIdRequest(parsedStartDate, parsedEndDate, carId, userId);

        return rentalService.getRentalId(request);
    }

}
