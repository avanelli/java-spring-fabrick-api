package com.fabrickdemo.rest.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService extends FabrickGenericService {

    public <T> ResponseEntity<?> moneyTransfer(String accountId, T requestData) {
        return new ResponseEntity<Object>(
            callFabrick(createUrl(accountId, "/payments/money-transfers"), HttpMethod.POST, requestData, Object.class ),
            HttpStatus.OK);        
    }        
    
}
