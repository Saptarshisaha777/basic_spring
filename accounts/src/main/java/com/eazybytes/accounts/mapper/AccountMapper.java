package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;

public class AccountMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setCustomerId(accounts.getCustomerId());
        accountsDto.setAccountNo(accounts.getAccountNo());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(Accounts accounts, AccountsDto accountsDto) {
        accounts.setCustomerId(accountsDto.getCustomerId());
       accounts.setAccountNo(accountsDto.getAccountNo());
       accounts.setBranchAddress(accountsDto.getBranchAddress());
       return accounts;
    }
}
