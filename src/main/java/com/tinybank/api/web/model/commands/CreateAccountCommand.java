package com.tinybank.api.web.model.commands;


import com.tinybank.api.web.model.domain.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CreateAccountCommand {
    @NotNull(message = "Name can not be empty")
    @Size(min = 3, message = "Name must be larger then 3 ")
    private String displayName;

    public Account toAccount() {
        return new Account(null,null,displayName);
    }
}
