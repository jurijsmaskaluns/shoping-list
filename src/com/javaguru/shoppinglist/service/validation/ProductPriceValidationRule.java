package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public Product validate(Product product) {
        if (product.getPrice().intValue() <= 0) {
            throw new ProductValidationException("цена продукта должна быть больше 0");
        }
        return product;
    }
}
