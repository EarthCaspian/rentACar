package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
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
@RequestMapping("api/corporateCustomer")
@AllArgsConstructor
@CrossOrigin
public class CorporateCustomersController {
	private final CorporateCustomerService corporateCustomerService;
	@PostMapping("/add")
	public Result add(@RequestBody @Valid AddCorporateCustomerRequest request){
		return corporateCustomerService.add(request);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCorporateCustomerRequest request) {
		return corporateCustomerService.update(request);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(DeleteCorporateCustomerRequest request) {
		return corporateCustomerService.delete(request);
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
