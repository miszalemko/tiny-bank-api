package com.tinybank.api.web.controllers;

import com.tinybank.api.web.dto.CustomerRepository;


import com.tinybank.api.web.model.commands.CreateCustomerCommand;
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.CustomerEntity;
import com.tinybank.api.web.services.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping()
    ResponseEntity<List<Customer>> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return ResponseEntity.ok().body(customerService.getCustomersFromCustomerEntities(customerEntities));
    }

    @PostMapping(value = "create")
    ResponseEntity<Void> createCustomer(@Valid @RequestBody CreateCustomerCommand customerCommand) {
        Customer customer = customerCommand.toCustomer();
        if(customer==null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<CustomerEntity> customerEntities = customerService.findCustomerByNameAndSurname(customer);
        if (customerEntities.isEmpty()) {
            CustomerEntity customerEntity = customerService.getCustomerEntityFromCustomer(customerCommand.toCustomer());
            customerRepository.save(customerEntity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
