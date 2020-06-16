package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductFieldValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getName().isEmpty() || productDto.getCategory().isEmpty() || productDto.getDescription().isEmpty()) {
            throw new ProductFieldException("One or more field is empty");
        }
    }
}
