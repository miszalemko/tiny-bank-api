package com.tinybank.api.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pkalamucki on 05.04.2018.
 */
public class Customer {
    private final String id;
    private final String name;
    private final String surname;
    private final Date birthDate;
    private final String address;
    private final List<Account> accounts;

    public Customer(String id, String name, String surname, Date birthDate, String address, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.accounts = new ArrayList<Account>(accounts);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return new ArrayList<Account>(accounts);
    }
}
