package com.tinybank.api.web;

<<<<<<< HEAD
import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
=======
import com.tinybank.api.web.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
>>>>>>> origin/master

}
