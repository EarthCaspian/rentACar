package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice extends BaseEntity {

    @Column(name="invoice_no")
    private String invoiceNo;

    @Column(name="total_price")
    private Float totalPrice;

    @Column(name="discount_rate")
    private Float discountRate;

    @Column(name="tax_rate")
    private Float taxRate;

    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;

}
