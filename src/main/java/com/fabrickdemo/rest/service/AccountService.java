package com.fabrickdemo.rest.service;

import com.fabrickdemo.rest.dto.*;
import com.fabrickdemo.rest.model.TransactionModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import com.fabrickdemo.rest.repositories.TransactionsRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AccountService extends FabrickGenericService {

    @Autowired
    protected TransactionsRepository transactionRepository;    
    
    public ResponseEntity<?> getBalance(String accountId) {
        return new ResponseEntity<Object>(
            callFabrick(createUrl(accountId, "/balance"), HttpMethod.GET),
            HttpStatus.OK);
    }

    public ResponseEntity<?> getTransactions(String accountId, String fromAccountingDate, String toAccountingDate) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(
            createUrl(accountId, "/transactions"))
         .queryParam("fromAccountingDate", fromAccountingDate)
         .queryParam("toAccountingDate", toAccountingDate);

        TransactionsDTO transactions = callFabrick(builder.toUriString(), HttpMethod.GET, null, TransactionsDTO.class);

        List<TransactionModel> tList =new ArrayList<>();
        for (TransactionDTO dto : transactions.getList()){
            TransactionModel transaction=new TransactionModel();
            transaction.setTransactionId(dto.getTransactionId());
            transaction.setAccountingDate(dto.getAccountingDate());
            transaction.setAmount(dto.getAmount());
            transaction.setCurrency(dto.getCurrency());
            transaction.setDescription(dto.getDescription());
            transaction.setValueDate(dto.getValueDate());
            transaction.setTypeEnumeration(dto.getType().getEnumeration());
            transaction.setTypeValue(dto.getType().getValue());
            transaction.setOperationId(dto.getOperationId());
            tList.add(transaction);
        }

        try{
           transactionRepository.saveAll(tList);
        }catch(Exception e){
            log.error("DB Error: " + e.getMessage());
        }        

        return new ResponseEntity<>(transactions.getList(), HttpStatus.OK);
    }        

}
