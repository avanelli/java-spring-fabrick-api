package com.fabrickdemo.rest.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDTO {
    public String transactionId;
    public String operationId;
    public Date accountingDate;
    public Date valueDate;
    public TransactionTypeDTO type;
    public BigDecimal amount;
    public String currency;
    public String description;    

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOperationId() {
        return this.operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Date getAccountingDate() {
        return this.accountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Date getValueDate() {
        return this.valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public TransactionTypeDTO getType() {
        return this.type;
    }

    public void setType(TransactionTypeDTO type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
