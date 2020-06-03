package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public Product validate(Product product) {
        if (product.getDiscount() < 0 || product.getDiscount() > 100) {
            throw new ProductValidationException("скидка не может быть больше 100 процентов и меньше 0");
        }
        return product;
    }
}
