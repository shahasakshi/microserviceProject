package com.accountservice.service;

import com.accountservice.model.Account;
import com.accountservice.model.Customer;
import com.accountservice.model.CustomerLocker;
import com.accountservice.repo.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Override
    public Account createAccount(Account account) {


        Date cuurent_date = new Date();
        account.setAccountOpeningDate(cuurent_date);

        account.setLastActivity(cuurent_date);

        return accountRepo.save(account);
    }

    @Override
    public List<Account> getALlAccount() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(String accountId) {
        //getting account by account service
        Account account = accountRepo.findById(accountId).get();

        //getting customer from customer sevice
        //http://localhost:1010/customer/id/

        Customer customer = restTemplate.getForObject("http://localhost:1010/customer/id/"+account.getCustomerId(), Customer.class);

        //getting customer locker details
        CustomerLocker customerLocker = restTemplate.getForObject("http://localhost:1100/locker/customer/"+account.getCustomerId(), CustomerLocker.class);

        account.setCustomerLocker(customerLocker);
        account.setCustomer(customer);
        return account;


    }

    @Override
    public Account updateAcc(String accounntId, Account account) {
        Account account1 = accountRepo.findById(accounntId).orElseThrow(null);
        account1.setAccountType(account.getAccountType());
        account1.setCustomerId(account.getCustomerId());
        account1.setLastActivity(new Date());
        return accountRepo.save(account1);

    }

    @Override
    public Account addBalance(String accountId, int amount, String customerId) {

        Account newAccount = accountRepo.findById(accountId).get();

        Customer customer = restTemplate.getForObject("http://localhost:1010/customer/id/"+customerId, Customer.class);

        if(customer == null){
            throw new IllegalArgumentException("customer with given id not found");
        }else
        {
            int addBalnce = newAccount.getBalance()+amount;
            newAccount.setBalance(addBalnce);
            newAccount.setLastActivity(new Date());

            return accountRepo.save(newAccount);
        }

    }

    @Override
    public Account withdrawBalance(String accountId, int amount, String customerId) {

        Account newAccount = accountRepo.findById(accountId).orElseThrow(null);

        Customer customer = restTemplate.getForObject("http://localhost:1010/customer/id/"+customerId, Customer.class);

        if(customer == null){
            throw new IllegalArgumentException("customer not found");

        }else{
            int newBalance = newAccount.getBalance() - amount;
            newAccount.setBalance(newBalance);
            return accountRepo.save(newAccount);
        }
    }

    @Override
    public void deleteAcc(String accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(null);
        accountRepo.delete(account);

    }

    @Override
    public List<Account> getAccountByCustomerId(String customerId) {
        return accountRepo.findByCustomerId(customerId);
    }
}
