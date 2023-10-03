package com.accountservice.controller;

import com.accountservice.model.Account;
import com.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/getAll")
    public List<Account> getAllAccount(){
        return accountService.getALlAccount();
    }

    @GetMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public Account getByAccountId(@PathVariable String accountId){
        return accountService.getAccountById(accountId);
    }

    //getbyCustId
    @GetMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getByCustomerId(@PathVariable String customerId){
        return accountService.getAccountByCustomerId(customerId);
    }

    @PutMapping("/update/{accountId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account update(@PathVariable String accountId,@RequestBody Account account){
        return accountService.updateAcc(accountId,account);
    }

    //add Balance
    @PutMapping("/addmoney/{accountId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addBalance(@PathVariable String accountId,@RequestParam int amount,@RequestParam String customerId){

       return accountService.addBalance(accountId,amount,customerId);
    }

    //withdraw balance
    @PutMapping("withdraw/{accountId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account withdrawBalance(@PathVariable String accountId,@RequestParam int amount,@RequestParam String customerId){
        return accountService.withdrawBalance(accountId,amount,customerId);
    }
}
