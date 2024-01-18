package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.specificexeptions.EntityNotFoundException;
import com.tobeto.rentACar.core.exceptions.specificexeptions.ErrorHandlingService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;
import com.tobeto.rentACar.services.rules.deneme.RentalBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final List<RentalBusinessRule> rentalBusinessRules;

    @Override
    public boolean existsRentalById(int id) {
        return rentalRepository.existsRentalById(id);
    }

    @Override
    public void add(AddRentalRequest request) {

        //rentalBusinessRules.forEach(rule -> rule.validateAdd(request));
       // rentalExistenceRules.validateAdd(request);

        //When renting, the StartKilometer should be taken from the Kilometer field of the vehicle to be rented.
        GetCarByIdResponse car = carService.getById(request.getCarId());
        Long currentCarKilometer = car.getKilometer();

        // TotalPrice should be calculated and saved (user will not provide)
        double dailyPrice = car.getDailyPrice();
        long rentalDays = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1;
        double totalPrice = dailyPrice * rentalDays;

        Rental rental = modelMapperService.forRequest().map(request, Rental.class);
        rental.setStartKilometer(currentCarKilometer);
        rental.setTotalPrice(totalPrice);
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest request) {
        rentalBusinessRules.forEach(rule -> rule.validateUpdate(request));

        //Mapping
        Rental rental = modelMapperService.forRequest().map(request, Rental.class);

        //Updating
        rentalRepository.save(rental);

    }

    @Override
    public void delete(DeleteRentalRequest request) {
        rentalBusinessRules.forEach(rule -> rule.validateDelete(request));

        //Deleting
        rentalRepository.deleteById(request.getId());
    }

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalsResponse> rentalsResponse = rentals.stream().map(rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalsResponse.class)).toList();
        return rentalsResponse;
    }

    @Override
    public GetRentalByIdResponse getById(int id) {

       //Checking whether the relevant rental exists or not
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorHandlingService.getRentalNotFoundMessage(id)));

        //Mapping
        return modelMapperService.forResponse().map(rental, GetRentalByIdResponse.class);

        /*GetRentalByIdResponse response = modelMapperService.forResponse().map(rentalRepository.findById(id), GetRentalByIdResponse.class);
        return response;*/
    }


}
