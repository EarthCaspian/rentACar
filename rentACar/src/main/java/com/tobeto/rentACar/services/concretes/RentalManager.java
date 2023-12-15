package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.abstracts.RentalService;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.response.GetAllRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final UserService userService;

    @Override
    public void add(AddRentalRequest request) {

        //Araç kiralarken verilen başlangıç tarihi bugünden daha geçmiş bi tarih olamaz.
        if (request.getStartDate().isBefore(LocalDate.now())){
            throw new RuntimeException("Start date cannot be in the past");
        }

        //Araç kiralarken verilen bitiş tarihi başlangıç tarihinden daha geçmiş bi tarih olamaz.
        if (request.getEndDate().isBefore(request.getStartDate())){
            throw new RuntimeException("End date cannot be before the start date");
        }

        //Araç kiralarken verilen CarId ile sistemde bir Araba olmalıdır.
        if (!carService.existsCarById(request.getCarId())) {
            throw new RuntimeException("There is no car with this id");
        }

        //Araç kiralarken verilen UserId ile sistemde bir User olmalıdır.
        if(!userService.existsUserById(request.getUserId())){
            throw new RuntimeException("There is no user with this id");
        }

        //Bir araç maksimum 25 gün kiralanabilir.
        if( ChronoUnit.DAYS.between(request.getStartDate(),request.getEndDate())>25){
            throw new RuntimeException("The rental period cannot exceed 25 days");
        }

        // Kiralama yapılırken StartKilometer kiralanmak istenen aracın Kilometer alanından alınmalıdır.
        //double startKilometer = request.getStartKilometer();
        Car car = carService.getById(request.getCarId());
        int currentCarKilometer = car.getKilometer();

        // totalPrice hesaplanarak kayıt edilmelidir (kullanıcı vermeyecek)
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

        Rental rental = modelMapperService.forRequest().map(request, Rental.class);
        rentalRepository.save(rental);

    }

    @Override
    public void delete(DeleteRentalRequest request) {
        rentalRepository.findById(request.getId()).orElseThrow();
        rentalRepository.deleteById(request.getId());
    }

    //@Override
    //public List<GetAllRentalResponse> getAll() {
        //return rentalRepository.getAll();
    //}
}
