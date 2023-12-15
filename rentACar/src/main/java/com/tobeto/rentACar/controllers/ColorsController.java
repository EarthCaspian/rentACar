package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorsController {
	private final ColorService colorService;

	@PostMapping
	public void add(@RequestBody @Valid AddColorRequest request){
		colorService.add(request);
	}
}
