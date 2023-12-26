package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;


@Table(name = "customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "birthdate")     //added
    private LocalDate birthdate;

    @Column(name = "international_id")      //added
    private String internationalId;

    @Column(name = "licence_issue_date")        //added
    private LocalDate licenceIssueDate;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;


    public  Integer getAge(LocalDate birthdate){        //added
        if (birthdate == null){
            return null;
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.from(birthdate), currentDate).getYears();
    }

}
