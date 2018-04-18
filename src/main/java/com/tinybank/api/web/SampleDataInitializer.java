package com.tinybank.api.web;


import com.tinybank.api.web.entities.Account;
import com.tinybank.api.web.entities.Customer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

        customerRepository.save(new Customer("firstName","firstSurname",
                new Date(), "firstAddress",null));
        customerRepository.save(new Customer("secondName","secondSurname",
                new Date(),"secondAddress",null));
        customerRepository.save(new Customer("thirdName","thirdSurname",
                new Date(),"thirdAddress",null));
    }
}
