package com.tobeto.rentACar.services.rules;

import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRule {
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final MessageService messageService;

    public void existsRentalById(int id) {
        if (!rentalRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.getRentalNotFoundMessage));
        }
    }

    public void checkRentalPeriod(LocalDate startDate, LocalDate endDate) {
        // One vehicle can be rented for a maximum of 25 days.
        if (ChronoUnit.DAYS.between(startDate, endDate) > 25) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.rentalPeriodExceedsLimit));
        }
    }

    public void checkStartDate(LocalDate startDate) {
        // The start date given when renting a car cannot be later than today.
        if (startDate.isBefore(LocalDate.now())) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.startDateInPast));
        }
    }

    public void checkEndDate(LocalDate startDate, LocalDate endDate) {
        // The end date given when renting a car cannot be later than the start date.
        if (endDate.isBefore(startDate)) {
            throw new BusinessException(messageService.getMessage(Messages.Rental.endDateBeforeStartDate));
        }
    }

    public void existsUserById(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new BusinessException(messageService.getMessage(Messages.User.getUserNotFoundMessage));
        }
    }

    public void existsCarById(int carId) {
        if (!carRepository.existsById(carId)) {
            throw new BusinessException(messageService.getMessage(Messages.Car.getCarNotFoundMessage));
        }
    }

}
