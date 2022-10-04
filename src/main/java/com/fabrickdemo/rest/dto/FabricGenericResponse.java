package com.fabrickdemo.rest.dto;

public class FabricGenericResponse<T> {
    private String status;
    private Object error;
    private T payload; 

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getError() {
        return this.error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
