package com.tinybank.api.web.controllers;

import com.tinybank.api.web.dto.CustomerRepository;


import com.tinybank.api.web.model.commands.CreateAccountCommand;
import com.tinybank.api.web.model.commands.CreateCustomerCommand;
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.AccountEntity;
import com.tinybank.api.web.model.entities.CustomerEntity;
import com.tinybank.api.web.services.AccountService;
import com.tinybank.api.web.services.CustomerService;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final AccountService accountService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @GetMapping()
    @ApiOperation(value= "gets list of all customers",response = Customer.class,tags = "Customers")
    ResponseEntity<List<Customer>> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return ResponseEntity.ok().body(customerService.getCustomersFromCustomerEntities(customerEntities));
    }

    @PostMapping(value = "create")
    @ApiOperation(value= "create customer if don't exist",response = Customer.class,tags = "Customers")
    ResponseEntity<Void> createCustomer(@Valid @RequestBody CreateCustomerCommand customerCommand) {
        Customer customer = customerCommand.toCustomer();
        if (customer == null) {
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

    @PostMapping(value = "{id}/createAccount")
    @ApiOperation(value= "creating account for customer if exist",response = Customer.class,tags = "Customers")
    ResponseEntity<Void> createAccountForExistingCustomer(@PathVariable Integer id, @Valid @RequestBody CreateAccountCommand createAccountCommand) {
        Customer customer = customerService.findCustomerById(id);

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        CustomerEntity customerEntity = customerService.getCustomerEntityFromCustomer(customer);
        List<AccountEntity> accountEntities = customerEntity.getAccounts();
        accountEntities.add(accountService.getAccountEntityFromAccount(createAccountCommand.toAccount()));
        customerEntity.setAccounts(accountEntities);
        customerRepository.save(customerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
