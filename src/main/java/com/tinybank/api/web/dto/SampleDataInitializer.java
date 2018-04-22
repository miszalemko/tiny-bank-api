package com.tinybank.api.web.dto;

import com.tinybank.api.web.model.entities.AccountEntity;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Component
public class SampleDataInitializer {
    private final CustomerRepository customerRepository;

    public SampleDataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    void init() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
                sdf.parse("21/12/1990"), "Amsterdam",adamAccounts));
        customerRepository.save(new CustomerEntity("Ben","Benassi",
                sdf.parse("1/3/1993"),"Berlin",benAccounts));
        customerRepository.save(new CustomerEntity("Cindy","Craul",
                sdf.parse("5/12/1985"),"C-Town",cindyAccounts));

    }
}
