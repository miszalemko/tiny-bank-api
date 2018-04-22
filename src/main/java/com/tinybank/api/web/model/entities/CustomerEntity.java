package com.tinybank.api.web.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "accounts")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Date birthDate;
    private String address;
    @OneToMany(cascade = {CascadeType.ALL})
    private  List<AccountEntity> accounts;

    public CustomerEntity(String name, String surname, Date birthDate, String address, List<AccountEntity> accounts) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.accounts = accounts;
    }
}
