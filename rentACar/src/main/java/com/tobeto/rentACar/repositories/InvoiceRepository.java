package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
