package com.tobeto.rentACar.services.rules.rental;

import com.tobeto.rentACar.services.dtos.rental.request.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.DeleteRentalRequest;
import com.tobeto.rentACar.services.dtos.rental.request.UpdateRentalRequest;
import org.springframework.stereotype.Service;


@Service
public abstract class RentalBusinessRule {
    public abstract void validateAdd(AddRentalRequest request);
    public abstract void validateUpdate(UpdateRentalRequest request);
    public abstract void validateDelete(DeleteRentalRequest request);

}
