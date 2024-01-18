package com.tobeto.rentACar.services.rules.deneme;

import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class RentalPeriodRule extends RentalBusinessRule {

    @Override
    public void validateAdd(AddRentalRequest request) {
        //One vehicle can be rented for a maximum of 25 days.
        if( ChronoUnit.DAYS.between(request.getStartDate(),request.getEndDate())>25){
            throw new RuntimeException("The rental period cannot exceed 25 days");
        }
        //The start date given when renting a car cannot be later than today.
        if (request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Start date cannot be in the past");
        }

        //The end date given when renting a car cannot be later than the start date.
        if (request.getEndDate().isBefore(request.getStartDate())){
            throw new RuntimeException("End date cannot be before the start date");
        }
    }

    @Override
    public void validateUpdate(UpdateRentalRequest request) {
        //One vehicle can be rented for a maximum of 25 days.
        if( ChronoUnit.DAYS.between(request.getStartDate(),request.getEndDate())>25){
            throw new RuntimeException("The rental period cannot exceed 25 days");
        }
        //The start date given when renting a car cannot be later than today.
        if (request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Start date cannot be in the past");
        }

        //The end date given when renting a car cannot be later than the start date.
        if (request.getEndDate().isBefore(request.getStartDate())){
            throw new RuntimeException("End date cannot be before the start date");
        }
    }

    @Override
    public void validateDelete(DeleteRentalRequest request) {

    }
}
