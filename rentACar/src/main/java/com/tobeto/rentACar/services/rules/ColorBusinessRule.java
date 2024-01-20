package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.ColorRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRule {

    private final ColorRepository colorRepository;
    private final MessageService messageService;

    public void existsColorByName (String name){
        if (colorRepository.existsColorByName(name)) {
            throw new BusinessException(messageService.getMessage(Messages.Color.getSameColorNameMessage));
        }
    }
    public void existsColorById(int id) {
        if (!colorRepository.existsColorById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Color.getColorNotFoundMessage));
        }
    }


}
