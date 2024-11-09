package com.eazybytes.accounts.services.impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exceptons.CustomerAlreadyExistException;
import com.eazybytes.accounts.exceptons.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already there w;ith this mobile number");
        }
       // customer.setCreatedAt(LocalDateTime.now());
       // customer.setCreatedBy("SYSTEM");
        Customer savedCustomer = customerRepository.save(customer);
        Accounts newAccount = createNewAccount(savedCustomer);
        //newAccount.setCreatedAt(LocalDateTime.now());
       // newAccount.setCreatedBy("SYSTEM");
        accountsRepository.save(newAccount);
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNo = 1000000000L + (long) (Math.random() * 9000000000L);
        newAccount.setAccountNo(randomAccNo);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
       return newAccount;
    }

    @Override
    public CustomerDto getCustomer(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString())
        );
        CustomerDto customerD = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerD.setAccountDetails(AccountMapper.mapToAccountsDto(account, new AccountsDto()));
        return customerD;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isupdated = false;
        AccountsDto accountsDto = customerDto.getAccountDetails();
        if(accountsDto == null) {
            return isupdated;
        }
        Accounts account = accountsRepository.findById(accountsDto.getAccountNo()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountNo", accountsDto.getAccountNo().toString())
        );
        AccountMapper.mapToAccounts(account, accountsDto);
        accountsRepository.save(account);
        Long customerId = account.getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
        );
        CustomerMapper.mapToCustomer(customer, customerDto);
        customerRepository.save(customer);
        isupdated = true;
        return isupdated;
    }
}
