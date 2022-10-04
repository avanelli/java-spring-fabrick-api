package com.fabrickdemo.rest.controller;

import org.springframework.web.bind.annotation.*;

import com.fabrickdemo.rest.service.PaymentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/accounts")
@CrossOrigin()
public class PaymentController {
    @Autowired
    PaymentsService paymentService;

    //example http://localhost:8080/14537780/payments/money-transfers
    @PostMapping(value = "/{accountId}/payments/money-transfers", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> moneyTransfer(@PathVariable String accountId, @RequestBody Object requestData) {
        return paymentService.moneyTransfer(accountId, requestData);
    }

}