package com.tobeto.rentACar.controllers;

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
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCustomerRequest request){
        customerService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCustomerRequest request){
        customerService.update(request);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteCustomerRequest request){
        customerService.delete(request);
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
