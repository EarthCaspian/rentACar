package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.repositories.ColorRepository;
import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public GetColorByIdResponse getByIdDTO(int id) {
        Color color = colorRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(color,GetColorByIdResponse.class);
    }

    @Override
    public List<GetAllColorsResponse> getAll() {
        return colorRepository.getAll();
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

    @Override
    public void update(UpdateColorRequest request) {
        if (colorRepository.existsColorByName(request.getName())) {
            throw new RuntimeException("Color with this name already exists!");
        }

        Color color = this.modelMapperService.forRequest()
                .map(request, Color.class);

        if (color == null) {
            throw new RuntimeException("No color found with this id:" + request.getId());
        }

        colorRepository.save(color);
    }

    @Override
    public void delete(int id) {
        colorRepository.deleteById(id);
    }
}
