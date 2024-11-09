package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    /*


     */
    void createAccount(CustomerDto customerDto);

    CustomerDto getCustomer(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
}
