package com.tinybank.api.web.dto;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
        List<CustomerEntity> findByNameAndSurname(String name, String surname);
}
