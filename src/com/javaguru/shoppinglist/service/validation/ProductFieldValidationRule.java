package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductFieldValidationRule implements ProductValidationRule {
    @Override
    public Product validate(Product product) {
        if (product.getName().isEmpty() || product.getCategory().isEmpty() || product.getDescription().isEmpty()) {
            throw new ProductFieldException("One or more field is empty");
        }
        return product;
    }
}
