package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.repositories.ColorRepository;
import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @Override
    public void add(AddColorRequest request) {
        if (colorRepository.existsColorByName(request.getName())) {
            throw new RuntimeException("Color with this name already exists!");
        }
        Color color = this.modelMapperService.forRequest()
                .map(request, Color.class);
        colorRepository.save(color);
    }
}
