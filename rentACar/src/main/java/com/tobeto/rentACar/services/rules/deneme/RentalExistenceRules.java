package com.tobeto.rentACar.services.rules.deneme;

import com.tobeto.rentACar.core.exceptions.specificexeptions.EntityNotFoundException;
import com.tobeto.rentACar.core.exceptions.specificexeptions.ErrorHandlingService;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class RentalExistenceRules extends RentalBusinessRule {
    private final UserService userService;
    private final CarService carService;
    private final RentalService rentalService;


    @Override
    public void validateAdd(AddRentalRequest request) {
        if (!userService.existsUserById(request.getUserId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getUserNotFoundMessage(request.getUserId()));
        }

        if (!carService.existsCarById(request.getCarId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getCarNotFoundMessage(request.getCarId()));
        }
    }

    @Override
    public void validateUpdate(UpdateRentalRequest request) {
        if (!rentalService.existsRentalById(request.getId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getRentalNotFoundMessage(request.getId()));
        }

        if (!userService.existsUserById(request.getUserId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getUserNotFoundMessage(request.getUserId()));
        }

        if (!carService.existsCarById(request.getCarId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getCarNotFoundMessage(request.getCarId()));
        }
    }

    @Override
    public void validateDelete(DeleteRentalRequest request) {
        if (!rentalService.existsRentalById(request.getId())) {
            throw new EntityNotFoundException(ErrorHandlingService.getRentalNotFoundMessage(request.getId()));
        }
    }
}
