package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorsController {
	private final ColorService colorService;


	@PostMapping("/add")
	public void add(@RequestBody @Valid AddColorRequest request){
		colorService.add(request);
	}

	@PutMapping("/update")
	public void update(@RequestBody @Valid UpdateColorRequest request) {
		colorService.update(request);
	}

	@GetMapping("/getAll")
	List<GetAllColorsResponse> getAll() {
	   return colorService.getAll();
	}

	@GetMapping("getByIdDTO/{id}")
	public GetColorByIdResponse getByIdDTO(@PathVariable int id) {
		return colorService.getByIdDTO(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		colorService.delete(id);
	}

}
