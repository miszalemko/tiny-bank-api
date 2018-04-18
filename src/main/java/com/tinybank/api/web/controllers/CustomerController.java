package com.tinybank.api.web.controllers;

import com.tinybank.api.web.CustomerRepository;
import com.tinybank.api.web.commands.CreateCustomerCommand;
import com.tinybank.api.web.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "all")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping(value = "create")
    @ResponseStatus(HttpStatus.CREATED)
    void createCustomer(@Valid @RequestBody CreateCustomerCommand customerCommand) {
        customerRepository.save(customerCommand.toCustomer());
    }


}
