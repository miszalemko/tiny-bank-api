package com.tinybank.api.web.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Date birthDate;
    private String address;
    @OneToMany
    private  List<Account> accountEntities;

    public Customer(String name, String surname, Date birthDate, String address, List<Account> accountEntities) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.accountEntities = accountEntities;
    }
}
