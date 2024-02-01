package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Invoice;
import com.tobeto.rentACar.services.dtos.invoice.response.GetAllInvoicesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
