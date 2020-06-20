package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductRepository;

public class ProductUniqueValidationRule implements ProductValidationRule{

    private final ProductRepository repository;

    public ProductUniqueValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDto productDto) {
        if(repository.findProductName(productDto.getName()).isPresent()){
            throw new IllegalArgumentException("Product name must be unique.");
        }

    }
}
