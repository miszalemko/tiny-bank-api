package com.tinybank.api.web.services;

import com.tinybank.api.web.CustomerRepository;
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountService accountService;


    public CustomerService(CustomerRepository customerRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
    }

    public List<Customer> getCustomersFromCustomerEntities(List<CustomerEntity> customerEntities) {
        List<Customer> customers = new ArrayList<>();
        for(CustomerEntity entity:customerEntities) {
            customers.add(new Customer(
                    String.valueOf(entity.getId()),
                    entity.getName(),
                    entity.getSurname(),
                    entity.getBirthDate(),
                    entity.getAddress(),
                    accountService.getAccountsFromAccountEntities(entity.getAccounts()))
            );
        }
        return customers;
    }

    public Customer getCustomerFromCustomerEntity(CustomerEntity customerEntity) {
        return new Customer(
                String.valueOf(customerEntity.getId()),
                customerEntity.getName(),
                customerEntity.getSurname(),
                customerEntity.getBirthDate(),
                customerEntity.getAddress(),
                accountService.getAccountsFromAccountEntities(customerEntity.getAccounts())
        );
    }
    public Customer getCustomerFromCustomerEntityAccountsAreNull(CustomerEntity customerEntity) {
        return new Customer(
                String.valueOf(customerEntity.getId()),
                customerEntity.getName(),
                customerEntity.getSurname(),
                customerEntity.getBirthDate(),
                customerEntity.getAddress(),
                null
        );
    }
}
