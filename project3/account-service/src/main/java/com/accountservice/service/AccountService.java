package com.accountservice.service;

import com.accountservice.model.Account;

import java.util.List;

public interface AccountService {

    //create
    Account createAccount(Account account);

    //getAllAccount

    List<Account> getALlAccount();

    //get account by Account id

    Account getAccountById(String accountId);

    //update account

    Account updateAcc(String accounntId,Account account);

    //update Balance

    Account addBalance(String accountId, int amount, String customerId);
    Account withdrawBalance(String accountId, int amount, String customerId);

    //delete account

    void deleteAcc(String accountId);


    //get single account using customerId

    List<Account> getAccountByCustomerId(String customerId);
}
