package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductNameLengthValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getName().length() < 3 || productDto.getName().length() > 32) {
            throw new ProductValidationException("название не может быть меньше 3 символов и больше 32");
        }
    }
}
