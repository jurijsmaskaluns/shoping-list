package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getPrice().intValue() <= 0) {
            throw new ProductValidationException("цена продукта должна быть больше 0");
        }
    }
}
