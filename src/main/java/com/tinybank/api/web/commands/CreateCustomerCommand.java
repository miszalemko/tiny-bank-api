package com.tinybank.api.web.commands;

import com.tinybank.api.web.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateCustomerCommand {

    @NotNull(message = "Name can not be empty")
    @Size(min = 3, message = "Name must be larger then 3 ")
    private final String name;
    @NotNull(message = "Surname can not be empty")
    @Size(min = 3, message = "Surname must be larger then 3 ")
    private final String surname;
    @NotNull(message = "Date can not be empty")
    private final Date birthDate;
    @NotNull(message = "Date can not be empty")
    @Size(min = 3, message = "Address must be larger then 3 ")
    private final String address;

    public Customer toCustomer() {
        return new Customer(name,surname,birthDate,address,new ArrayList<>());
    }
}
