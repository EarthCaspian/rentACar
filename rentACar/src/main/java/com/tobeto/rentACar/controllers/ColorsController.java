package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
@AllArgsConstructor
@CrossOrigin
public class ColorsController {
	private final ColorService colorService;

	@PostMapping("/add")
	public Result add(@RequestBody @Valid AddColorRequest request){
		return colorService.add(request);
	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateColorRequest request) {
		return colorService.update(request);
	}

	@GetMapping("/getAll")
	List<GetAllColorsResponse> getAll() {
	   return colorService.getAll();
	}

	@GetMapping("getById/{id}")
	public GetColorByIdResponse getById(@PathVariable int id) {
		return colorService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@RequestBody @Valid DeleteColorRequest request) {
		return colorService.delete(request);
	}

}
