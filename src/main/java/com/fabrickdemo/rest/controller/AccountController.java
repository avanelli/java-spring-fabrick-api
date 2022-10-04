package com.fabrickdemo.rest.controller;

import org.springframework.web.bind.annotation.*;

import com.fabrickdemo.rest.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/accounts")
@CrossOrigin()
public class AccountController {
    @Autowired
    AccountService accountService;

    //example http://localhost:8080/14537780/balance
    @GetMapping(value = "{accountId}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBalance(@PathVariable String accountId) {
        return accountService.getBalance(accountId); // "14537780"
    }

    //example http://localhost:8080/14537780/transactions?fromAccountingDate=2019-04-01&toAccountingDate=2022-04-01
    @GetMapping(value = "/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getTransactions(@PathVariable String accountId, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) {
        return accountService.getTransactions(accountId, fromAccountingDate, toAccountingDate);
    }

}