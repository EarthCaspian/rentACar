package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetAllCustomersResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddCustomerRequest request){
        return customerService.add(request);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateCustomerRequest request){
        return customerService.update(request);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCustomerRequest request){
        return customerService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetAllCustomersResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetCustomerByIdResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

}
