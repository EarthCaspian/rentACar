package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.constants.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RentalBusinessRuleTest {

    private RentalBusinessRule rentalBusinessRule;

    @Mock
    private RentalRepository rentalRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rentalBusinessRule = new RentalBusinessRule(rentalRepository, userRepository,carRepository,messageService);
    }

    //  TEST CODES - existsRentalById
    @Test
    void existsRentalById_WhenRentalExists_ShouldNotThrowException() {
        // Arrange
        int id = 1;
        when(rentalRepository.existsById(id)).thenReturn(true);

        // Act & Assert
        assertDoesNotThrow(() -> rentalBusinessRule.existsRentalById(id));

        // Verify
        verify(rentalRepository).existsById(id);
    }

    @Test
    void existsRentalById_WhenRentalDoesNotExists_ShouldThrowException() {
        //  Arrange
        int id = 1;
        when(rentalRepository.existsById(id)).thenReturn(false);
        // Mocking the message service
        when(messageService.getMessage(Messages.Rental.getRentalNotFoundMessage))
                .thenReturn("Rental not found");

        //  Act & Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.existsRentalById(id));
        assertEquals("Rental not found", exception.getMessage());

        //  Verify
        verify(rentalRepository).existsById(id);
    }

    //  TEST CODES - existsRentalPeriod
    @Test
    public void checkRentalPeriod_WhenPeriodWithinLimit_ShouldNotThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 20);

        // Act and Assert
        assertDoesNotThrow(() -> rentalBusinessRule.checkRentalPeriod(startDate, endDate));
    }

    @Test
    public void checkRentalPeriod_WhenPeriodExceedsLimit_ShouldThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 2, 1);

        // Mocking the message service
        when(messageService.getMessage(Messages.Rental.rentalPeriodExceedsLimit))
                .thenReturn("Rental period exceeds limit");

        // Act and Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.checkRentalPeriod(startDate, endDate));

        //  Verify
        assertEquals("Rental period exceeds limit", exception.getMessage());
    }

    //  TEST CODES - checkStartDate
    @Test
    public void checkStartDate_WhenStartDateIsToday_ShouldNotThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.now();

        // Act and Assert
        assertDoesNotThrow(() -> rentalBusinessRule.checkStartDate(startDate));
    }

    @Test
    public void checkStartDate_WhenStartDateIsBeforeToday_ShouldThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.now().minusDays(1);

        // Mocking the message service
        when(messageService.getMessage(Messages.Rental.startDateInPast))
                .thenReturn("Start date cannot be in the past");

        // Act and Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.checkStartDate(startDate));

        //  Verify
        assertEquals("Start date cannot be in the past", exception.getMessage());
    }

    //  TEST CODES - checkEndDate
    @Test
    public void checkEndDate_WhenEndDateIsAfterStartDate_ShouldNotThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 10);

        // Act and Assert
        assertDoesNotThrow(() -> rentalBusinessRule.checkEndDate(startDate, endDate));
    }

    @Test
    public void checkEndDate_WhenEndDateIsBeforeStartDate_ShouldThrowException() {
        // Arrange
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        // Mocking the message service
        when(messageService.getMessage(Messages.Rental.endDateBeforeStartDate))
                .thenReturn("End date cannot be before start date");

        // Act and Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.checkEndDate(startDate, endDate));

        //  Verify
        assertEquals("End date cannot be before start date", exception.getMessage());
    }

    //  TEST CODES - existsUserById
    @Test
    public void existsUserById_WhenUserExists_ShouldNotThrowException() {
        // Arrange
        int userId = 1;
        when(userRepository.existsById(userId)).thenReturn(true);

        // Act and Assert
        assertDoesNotThrow(() -> rentalBusinessRule.existsUserById(userId));

        // Verify
        verify(userRepository).existsById(userId);
    }

    @Test
    public void existsUserById_WhenUserDoesNotExist_ShouldThrowException() {
        // Arrange
        int userId = 1;
        when(userRepository.existsById(userId)).thenReturn(false);
        when(messageService.getMessage(Messages.User.getUserNotFoundMessage))
                .thenReturn("User not found");

        // Act and Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.existsUserById(userId));
        assertEquals("User not found", exception.getMessage());

        // Verify
        verify(userRepository).existsById(userId);
    }

    //  TEST CODES - existsCarById
    @Test
    public void existsCarById_WhenCarExists_ShouldNotThrowException() {
        // Arrange
        int carId = 1;
        when(carRepository.existsById(carId)).thenReturn(true);

        // Act and Assert
        assertDoesNotThrow(() -> rentalBusinessRule.existsCarById(carId));

        // Verify
        verify(carRepository).existsById(carId);
    }

    @Test
    public void existsCarById_WhenCarDoesNotExist_ShouldThrowException() {
        // Arrange
        int carId = 1;
        when(carRepository.existsById(carId)).thenReturn(false);
        when(messageService.getMessage(Messages.Car.getCarNotFoundMessage))
                .thenReturn("Car not found");

        // Act and Assert
        BusinessException exception = assertThrows(BusinessException.class,
                () -> rentalBusinessRule.existsCarById(carId));
        assertEquals("Car not found", exception.getMessage());

        // Verify
        verify(carRepository).existsById(carId);
    }
}