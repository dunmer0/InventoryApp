package com.woodhome.stockmanager.exception;

import org.springframework.http.HttpStatus;

public class InventoryAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public InventoryAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public InventoryAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
