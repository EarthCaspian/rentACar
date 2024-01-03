package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Invoice;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT new com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse" +
            "(i.invoiceNo, i.totalPrice, i.discountRate, i.taxRate" +
            " new com.tobeto.rentACar.services.dtos.rental.response.GetRentalByIdResponse(r.id, r.startDate, r.endDate, r.returnDate))" +
            " FROM Invoice i INNER JOIN i.rental r")
    List<GetAllInvoicesResponse> getAll();
}
