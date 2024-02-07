package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.repositories.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BrandBusinessRuleTest {

    private BrandBusinessRule brandBusinessRule;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandBusinessRule = new BrandBusinessRule(brandRepository,messageService);
    }

    @Test
    void shouldThrowExceptionWhenBrandIdDoesNotExist() {

        int id = 1;
        when(brandRepository.existsById(id)).thenReturn(false);

        assertThrows(BusinessException.class,() -> brandBusinessRule.existsBrandById(id));

        verify(brandRepository).existsById(id);

    }

    @Test
    void brandWithSameNameShouldNotExist() {

        String name = "Tesla";
        when(brandRepository.existsByName(name)).thenReturn(true);

        assertThrows(BusinessException.class, ()-> brandBusinessRule.existsBrandByName(name));

        verify(brandRepository).existsByName(name);

    }
}