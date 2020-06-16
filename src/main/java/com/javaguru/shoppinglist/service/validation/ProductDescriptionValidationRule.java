package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductDescriptionValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDescription() == null || productDto.getDescription().isEmpty()) {
            throw new ProductValidationException("Product description must be not null");
        }
    }
}
