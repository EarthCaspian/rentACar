package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.AddCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.DeleteCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.request.UpdateCorporateCustomerRequest;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetAllCorporateCustomersResponse;
import com.tobeto.rentACar.services.dtos.corporateCustomer.response.GetCorporateCustomerByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporateCustomer")
@AllArgsConstructor
public class CorporateCustomerController {
	private final CorporateCustomerService corporateCustomerService;
	@PostMapping("/add")
	void add(@RequestBody @Valid AddCorporateCustomerRequest request){
		corporateCustomerService.add(request);
	}

	@PutMapping("/update")
	void update(@RequestBody @Valid UpdateCorporateCustomerRequest request) {
		corporateCustomerService.update(request);
	}

	@DeleteMapping("/delete/{id}")
	void delete(DeleteCorporateCustomerRequest request) {
		corporateCustomerService.delete(request);
	}

	@GetMapping("/getAll")
	public List<GetAllCorporateCustomersResponse> getAll() {
		return corporateCustomerService.getAll();
	}

	@GetMapping("/getById/{id}")
	public GetCorporateCustomerByIdResponse getById(@PathVariable int id){
		return corporateCustomerService.getById(id);
	}
}
