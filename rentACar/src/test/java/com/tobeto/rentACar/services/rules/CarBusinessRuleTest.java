package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.repositories.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class CarBusinessRuleTest {

    private CarBusinessRule carBusinessRule;

    @Mock
    private CarRepository carRepository;

    @Mock
    private MessageService messageService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        carBusinessRule = new CarBusinessRule(carRepository, messageService);
    }

    @Test
    void shouldThrowExceptionWhenCarIdDoesNotExist(){

        int id = 1;
        when(carRepository.existsById(id)).thenReturn(false);
        assertThrows(BusinessException.class,() -> carBusinessRule.existsCarById(id));
        verify(carRepository).existsById(id);

    }

    @Test
    void carWithSamePlateShouldNotExist(){

        String plate = "34ABC123";

        when(carRepository.existsCarByPlate(plate)).thenReturn(true);
        assertThrows(BusinessException.class, () -> carBusinessRule.existsCarByPlate(plate));
        verify(carRepository).existsCarByPlate(plate);

    }
}
