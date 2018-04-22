package com.tinybank.api.web.controllers;

import com.tinybank.api.web.CustomerRepository;
<<<<<<< HEAD
import com.tinybank.api.web.model.commands.CreateCustomerCommand;
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.CustomerEntity;
import com.tinybank.api.web.services.CustomerService;
=======
import com.tinybank.api.web.commands.CreateCustomerCommand;
import com.tinybank.api.web.entities.Customer;
>>>>>>> origin/master
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
<<<<<<< HEAD
    private final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
=======

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
>>>>>>> origin/master
    }

    @GetMapping(value = "all")
    List<Customer> getAllCustomers() {
<<<<<<< HEAD
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerService.getCustomersFromCustomerEntities(customerEntities);
=======
        return customerRepository.findAll();
>>>>>>> origin/master
    }

    @PostMapping(value = "create")
    @ResponseStatus(HttpStatus.CREATED)
    void createCustomer(@Valid @RequestBody CreateCustomerCommand customerCommand) {
        customerRepository.save(customerCommand.toCustomer());
    }


}
