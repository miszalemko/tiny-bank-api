package com.tinybank.api.web.model.commands;

import com.tinybank.api.web.model.domain.Customer;
import com.tinybank.api.web.model.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CreateCustomerCommand {

    @NotNull(message = "Name can not be empty")
    @Size(min = 3, message = "Name must be larger then 3 ")
    private String name;
    @NotNull(message = "Surname can not be empty")
    @Size(min = 3, message = "Surname must be larger then 3 ")
    private String surname;
    @NotNull(message = "Date can not be empty")
    private Date birthDate;
    @NotNull(message = "Date can not be empty")
    @Size(min = 3, message = "Address must be larger then 3 ")
    private String address;

    public Customer toCustomer() {
        return new Customer(null,name,surname,birthDate,address,new ArrayList<>());
    }


}
