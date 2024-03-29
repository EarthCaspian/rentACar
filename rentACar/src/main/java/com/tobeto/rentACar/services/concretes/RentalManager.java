package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.FindRentalIdRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.*;


import com.tobeto.rentACar.services.rules.RentalBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import java.util.Optional;

import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final List<RentalBusinessRule> rentalBusinessRules;
    private MessageService messageService;

    @Override
    public AddRentalResponse add(AddRentalRequest request) {

        for (RentalBusinessRule rule : rentalBusinessRules) {
            rule.checkRentalPeriod(request.getStartDate(), request.getEndDate());
            rule.checkStartDate(request.getStartDate());
            rule.checkEndDate(request.getStartDate(), request.getEndDate());
            rule.existsUserById(request.getUserId());
            rule.existsCarById(request.getCarId());
        }

        //When renting, the StartKilometer should be taken from the Kilometer field of the vehicle to be rented.
        GetCarByIdResponse car = carService.getById(request.getCarId());
        Long currentCarKilometer = car.getKilometer();

        // TotalPrice should be calculated and saved (user will not provide)
        Float dailyPrice = car.getDailyPrice();
        double totalPrice;
        if (request.getStartDate().isEqual(request.getEndDate())) {
            totalPrice = dailyPrice;
        } else {
            long rentalDays = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
            totalPrice = dailyPrice * rentalDays;
        }

        Rental rental = modelMapperService.forRequest().map(request, Rental.class);
        rental.setStartKilometer(currentCarKilometer);
        rental.setTotalPrice(totalPrice);
        Rental savedRental = rentalRepository.save(rental);
        Result result = new SuccessResult(messageService.getMessage(Messages.Rental.rentalAddSuccess));

        AddRentalResponse addRentalResponse = new AddRentalResponse();
        addRentalResponse.setId(savedRental.getId());
        addRentalResponse.setResult(result);

        return (addRentalResponse);

    }

    @Override
    public Result update(UpdateRentalRequest request) {

        for (RentalBusinessRule rule : rentalBusinessRules ) {
            rule.existsRentalById(request.getId());
            rule.checkRentalPeriod(request.getStartDate(), request.getEndDate());
            rule.checkStartDate(request.getStartDate());
            rule.checkEndDate(request.getStartDate(), request.getEndDate());
            rule.existsUserById(request.getUserId());
            rule.existsCarById(request.getCarId());
        }

        //Mapping
        Rental rental = modelMapperService.forRequest().map(request, Rental.class);

        //Updating
        rentalRepository.save(rental);

        return new SuccessResult(messageService.getMessage(Messages.Rental.rentalUpdateSuccess));

    }

    @Override
    public Result delete(DeleteRentalRequest request) {

        RentalBusinessRule rule = rentalBusinessRules.get(0);

        rule.existsRentalById(request.getId());

        //Deleting
        rentalRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Rental.rentalDeleteSuccess));

    }

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalsResponse> rentalsResponse = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetAllRentalsResponse.class)).toList();
        return rentalsResponse;
    }

    @Override
    public GetRentalByIdResponse getById(int id) {

        Rental rental = rentalRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Rental.getRentalNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(rental, GetRentalByIdResponse.class);
    }

    @Override
    public GetRentalIdResponse getRentalId(FindRentalIdRequest request) {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream()
                .filter(rental -> rental.getStartDate().isEqual(request.getStartDate()) &&
                        rental.getEndDate().isEqual(request.getEndDate()) &&
                        rental.getCar().getId() == request.getCarId() &&
                        rental.getUser().getId() == request.getUserId())
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetRentalIdResponse.class))
                .reduce((first, second) -> second) // Get the last element
                .orElse(null);
    }

    public List<GetRentalByUserIdResponse> getByUserId(int userId) {
        List<Rental> rentals = rentalRepository.findByUserId(userId);

        if (rentals.isEmpty()) {
            throw new NotFoundException(messageService.getMessage(Messages.Rental.getRentalNotFoundMessage));
        }

        List<GetRentalByUserIdResponse> rentalsByUserId = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetRentalByUserIdResponse.class)).toList();
        return rentalsByUserId;
    }



}
