package com.fabrickdemo.rest.dto;

import java.util.ArrayList;

public class TransactionsDTO {
    public ArrayList<TransactionDTO> list;

    public ArrayList<TransactionDTO> getList() {
        return this.list;
    }

    public void setList(ArrayList<TransactionDTO> list) {
        this.list = list;
    }
}
