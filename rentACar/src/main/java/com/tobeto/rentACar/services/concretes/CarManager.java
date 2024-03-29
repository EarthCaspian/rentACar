package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.messages.MessageService;
import com.tobeto.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentACar.core.utilities.results.Result;
import com.tobeto.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.rentACar.entities.concretes.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.constants.Messages;
import com.tobeto.rentACar.services.dtos.car.request.AddCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.DeleteCarRequest;
import com.tobeto.rentACar.services.dtos.car.request.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.car.response.GetAllCarsResponse;
import com.tobeto.rentACar.services.dtos.car.response.GetCarByIdResponse;
import com.tobeto.rentACar.services.rules.CarBusinessRule;
import com.tobeto.rentACar.services.rules.ColorBusinessRule;
import com.tobeto.rentACar.services.rules.ModelBusinessRule;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRule carBusinessRule;
    private final ModelBusinessRule modelBusinessRule;
    private final ColorBusinessRule colorBusinessRule;
    private MessageService messageService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map((car) -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    public GetCarByIdResponse getById(int id) {

        Car car = carRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Car.getCarNotFoundMessage)));

        //Mapping the object to the response object
        return this.modelMapperService.forResponse()
                .map(car, GetCarByIdResponse.class);
    }

    @Override
    public Result add(AddCarRequest request) {

        //The input is converted as compatible with the database
        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));

        carBusinessRule.existsCarByPlate(request.getPlate());
        modelBusinessRule.existsModelById(request.getModelId());
        colorBusinessRule.existsColorById(request.getColorId());

        Car car = this.modelMapperService.forRequest().map(request, Car.class);

        carRepository.save(car);

        return new SuccessResult(messageService.getMessage(Messages.Car.carAddSuccess));
    }

    @Override
    public Result update(UpdateCarRequest request) {

        //The input is converted as compatible with the database
        request.setPlate(request.getPlate().replaceAll("[\\s-]", ""));

        carBusinessRule.existsCarByPlate(request.getPlate());
        modelBusinessRule.existsModelById(request.getModelId());
        colorBusinessRule.existsColorById(request.getColorId());

        Car car = this.modelMapperService.forRequest().map(request, Car.class);

        carRepository.save(car);

        return new SuccessResult(messageService.getMessage(Messages.Car.carUpdateSuccess));

    }

    @Override
    public Result delete(DeleteCarRequest request) {

        carBusinessRule.existsCarById(request.getId());

        carRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Car.carDeleteSuccess));

    }

}
