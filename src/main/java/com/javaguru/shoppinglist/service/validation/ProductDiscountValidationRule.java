package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDiscount() < 0 || productDto.getDiscount() > 100) {
            throw new ProductValidationException("скидка не может быть больше 100 процентов и меньше 0");
        }
    }
}
