package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.entities.concretes.Invoice;
import com.tobeto.rentACar.entities.concretes.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.invoice.response.GetInvoiceByIdResponse;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalsResponse;
import com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final UserService userService;

    @Override
    public void add(AddRentalRequest request) {

        //The start date given when renting a car cannot be later than today.
        if (request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Start date cannot be in the past");
        }

        //The end date given when renting a car cannot be later than the start date.
        if (request.getEndDate().isBefore(request.getStartDate())){
            throw new RuntimeException("End date cannot be before the start date");
        }

        //There must be a Car in the system with the CarId provided when renting a car.
        if (!carService.existsCarById(request.getCarId())) {
            throw new RuntimeException("There is no car with this id");
        }

        //There must be a User in the system with the UserId given when renting a car.
        if(!userService.existsUserById(request.getUserId())){
            throw new RuntimeException("There is no user with this id");
        }

        //One vehicle can be rented for a maximum of 25 days.
        if( ChronoUnit.DAYS.between(request.getStartDate(),request.getEndDate())>25){
            throw new RuntimeException("The rental period cannot exceed 25 days");
        }

        //When renting, the StartKilometer should be taken from the Kilometer field of the vehicle to be rented.
        Car car = carService.getById(request.getCarId());
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

        //Mapping
        Rental rental = modelMapperService.forRequest().map(request, Rental.class);

        //Updating
        rentalRepository.save(rental);

    }

    @Override
    public void delete(DeleteRentalRequest request) {

        //Checking whether the relevant rental exists or not
        rentalRepository.findById(request.getId()).orElseThrow(() ->
                new NoSuchElementException("Rental not found with ID: " + request.getId()));

        //Deleting
        rentalRepository.deleteById(request.getId());
    }

    @Override
    public List<GetAllRentalsResponse> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public GetRentalByIdResponse getById(int id) {

        //Checking whether the relevant rental exists or not
        Rental rental = rentalRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Rental not found with ID: " + id));

        //Mapping
        return modelMapperService.forResponse().map(rental, GetRentalByIdResponse.class);
    }


}
