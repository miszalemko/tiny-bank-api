package com.tinybank.api.web;


<<<<<<< HEAD
import com.tinybank.api.web.model.domain.Account;
import com.tinybank.api.web.model.entities.AccountEntity;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
=======
import com.tinybank.api.web.entities.Account;
import com.tinybank.api.web.entities.Customer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Configuration
public class SampleDataInitializer {
    private final CustomerRepository customerRepository;

    public SampleDataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    void init() {
<<<<<<< HEAD
        List<AccountEntity> adamAccounts = new ArrayList<>();
        adamAccounts.add(new AccountEntity(null,"FirstAccountOfAdam"));
        adamAccounts.add(new AccountEntity(null,"SecondAccountOfAdam"));
        List<AccountEntity> benAccounts = new ArrayList<>();
        benAccounts.add(new AccountEntity(null,"FirstAccountOfBen"));
        benAccounts.add(new AccountEntity(null,"SecondAccountOfBen"));
        List<AccountEntity> cindyAccounts = new ArrayList<>();
        cindyAccounts.add(new AccountEntity(null,"FirstAccountOfCindy"));
        cindyAccounts.add(new AccountEntity(null,"SecondAccountOfCindy"));
        customerRepository.save(new CustomerEntity("Adam","Adamczyk",
                new Date(), "Amsterdam",adamAccounts));
        customerRepository.save(new CustomerEntity("Ben","Benassi",
                new Date(),"Berlin",benAccounts));
        customerRepository.save(new CustomerEntity("Cindy","Craul",
                new Date(),"C-Town",cindyAccounts));
=======

        customerRepository.save(new Customer("firstName","firstSurname",
                new Date(), "firstAddress",null));
        customerRepository.save(new Customer("secondName","secondSurname",
                new Date(),"secondAddress",null));
        customerRepository.save(new Customer("thirdName","thirdSurname",
                new Date(),"thirdAddress",null));
>>>>>>> origin/master
    }
}
