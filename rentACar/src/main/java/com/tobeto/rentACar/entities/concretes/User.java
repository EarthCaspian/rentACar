package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user")
    List<Customer> customers;

    @OneToMany(mappedBy = "user")
    List<CorporateCustomer> corporateCustomers;

}
