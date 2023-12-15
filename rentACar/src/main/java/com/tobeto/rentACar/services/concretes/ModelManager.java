package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import com.tobeto.rentACar.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow();
    }
}
