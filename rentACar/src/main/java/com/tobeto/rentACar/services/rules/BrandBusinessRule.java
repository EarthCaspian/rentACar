package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.exceptions.internationalization.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRule {

    private final BrandRepository brandRepository;
    private final MessageService messageService;

    public void existsBrandByName (String name){
        if (brandRepository.existsByName(name))
            throw new BusinessException(messageService.getMessage(Messages.Brand.getBrandNameAlreadyExistsMessage));
    }
    public void existsBrandById(int id) {
        if (!brandRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Brand.getBrandNotFoundMessage));
        }
    }
}
