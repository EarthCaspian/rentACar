package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.tobeto.rentACar.entities.Brand;
@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    BrandRepository brandRepository;

    @Override
    public List<String> getAll() {
        return brandRepository.findAll().stream()
                .map(Brand::getName)
                .collect(Collectors.toList());
    }
}
