package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameLengthValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("название не может быть меньше 3 символов и больше 32");
        }
    }
}
