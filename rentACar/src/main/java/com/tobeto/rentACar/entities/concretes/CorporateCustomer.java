package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="corporate_customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends BaseEntity {
    @Column(name="company_name")
    private String companyName;

    @Column(name="tax_no")
    private String taxNo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
