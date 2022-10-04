package com.fabrickdemo.rest.dto;

public class TransactionTypeDTO {
    public String enumeration;
    public String value;    

    public String getEnumeration() {
        return this.enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
