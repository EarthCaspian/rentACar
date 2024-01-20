package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.ModelRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRule {
    private final ModelRepository modelRepository;
    private final MessageService messageService;

    public void existsModelById(int id) {
        if (!modelRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Model.getModelNotFoundMessage));
        }
    }

    public void existsModelByName (String name){
        if (modelRepository.existsByName(name))
            throw new BusinessException(messageService.getMessage(Messages.Model.getModelNameAlreadyExistsMessage));
    }
}
