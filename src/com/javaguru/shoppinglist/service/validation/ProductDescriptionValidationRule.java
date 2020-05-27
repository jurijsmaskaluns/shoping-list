package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDescriptionValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDescription() == null) {
            throw new ProductValidationException("Product description must be not null");
        }
    }
}
