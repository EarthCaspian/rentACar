package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Color;
import com.tobeto.rentACar.repositories.ColorRepository;
import com.tobeto.rentACar.services.abstracts.ColorService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentACar.services.dtos.color.request.UpdateColorRequest;
import com.tobeto.rentACar.services.dtos.color.response.GetAllColorsResponse;
import com.tobeto.rentACar.services.dtos.color.response.GetColorByIdResponse;
import com.tobeto.rentACar.services.rules.ColorBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    private final ColorBusinessRule colorBusinessRule;
    private MessageService messageService;

    @Override
    public GetColorByIdResponse getById(int id) {

        Color color = colorRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Color.getColorNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(color, GetColorByIdResponse.class);
    }

    @Override
    public List<GetAllColorsResponse> getAll() {
        List<Color> colors = colorRepository.findAll();
        return colors
                .stream()
                .map(color -> this.modelMapperService
                        .forResponse()
                        .map(color, GetAllColorsResponse.class))
                .toList();
    }

    @Override
    public Result add(AddColorRequest request) {

        colorBusinessRule.existsColorByName(request.getName());

        Color color = this.modelMapperService.forRequest()
                .map(request, Color.class);
        colorRepository.save(color);

        return new SuccessResult(messageService.getMessage(Messages.Color.colorAddSuccess));

    }

    @Override
    public Result update(UpdateColorRequest request) {
        colorBusinessRule.existsColorByName(request.getName());
        colorBusinessRule.existsColorById(request.getId());

        Color color = this.modelMapperService.forRequest()
                .map(request, Color.class);

        colorRepository.save(color);

        return new SuccessResult(messageService.getMessage(Messages.Color.colorUpdateSuccess));

    }

    @Override
    public Result delete(DeleteColorRequest request) {

        colorBusinessRule.existsColorById(request.getId());

        colorRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Color.colorDeleteSuccess));
    }
}
