package com.tinybank.api.web.services;

import com.tinybank.api.web.dto.CustomerRepository;
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.AccountEntity;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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

    public CustomerEntity getCustomerEntityFromCustomer (Customer customer) {
        return new CustomerEntity(Integer.valueOf(customer.getId()),
                customer.getName(),
                customer.getSurname(),
                customer.getBirthDate(),
                customer.getAddress(),
                accountService.getAccountEntitiesFromAccounts(customer.getAccounts()));
    }

    public List<CustomerEntity> findCustomerByNameAndSurname(Customer customer) {
        CustomerEntity customerEntity = getCustomerEntityFromCustomer(customer);
        return customerRepository.findByNameAndSurname(customerEntity.getName(),customerEntity.getSurname());
    }

    public Customer findCustomerById(Integer id) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(id);
        CustomerEntity customerEntity = customerEntityOptional.get();
        return getCustomerFromCustomerEntity(customerEntity);
    }

}
