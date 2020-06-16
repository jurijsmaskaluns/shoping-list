package com.javaguru.shoppinglist.service.validation;

public class ProductFieldException extends RuntimeException {
    public ProductFieldException(String message) {
        super(message);
    }
}
