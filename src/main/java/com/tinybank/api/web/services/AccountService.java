package com.tinybank.api.web.services;

import com.tinybank.api.web.model.domain.Account;
import com.tinybank.api.web.model.entities.AccountEntity;
import com.tinybank.api.web.model.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    public List<Account> getAccountsFromAccountEntities (List<AccountEntity> accountEntities) {
        List<Account> accounts = new ArrayList<>();
        for(AccountEntity entity:accountEntities) {
            accounts.add(new Account(
                    String.valueOf(entity.getId()),
                    null,
                    entity.getDisplayName()));
        }
        return accounts;
    }

    public AccountEntity getAccountEntityFromAccount(Account account) {
        return new AccountEntity(null,account.getDisplayName());
    }

    public List<AccountEntity> getAccountEntitiesFromAccounts(List<Account> accounts) {
        List<AccountEntity> accountEntities = new ArrayList<>();
        for(Account account:accounts) {
            accountEntities.add(new AccountEntity(
                    Integer.valueOf(account.getId()),
                    null,
                    account.getDisplayName()
            ));
        }
        return accountEntities;
    }

}
