package com.fabrickdemo.rest.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="transactions")
public class TransactionModel {

    public TransactionModel() {
    }

    @Id
    @Column(name="transactionId")
    private String transactionId;

    @Column(name="operationId")
    private String operationId;

    @Column(name="accountingDate")
    private Date accountingDate;

    @Column(name="valueDate")
    private Date valueDate;

    @Column(name="type_enumeration")
    private String typeEnumeration;

    @Column(name="type_value")
    private String typeValue;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="currency")
    private String currency;

    @Column(name="description")
    private String description;

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

    public String getTypeEnumeration() {
        return this.typeEnumeration;
    }

    public void setTypeEnumeration(String typeEnumeration) {
        this.typeEnumeration = typeEnumeration;
    }

    public String getTypeValue() {
        return this.typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
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

