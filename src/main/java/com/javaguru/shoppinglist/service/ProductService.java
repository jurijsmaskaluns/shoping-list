package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;
    private final BeanMapper beanMapper;

    public ProductService(ProductRepository productRepository, ProductValidationService validationService, BeanMapper beanMapper) {
        this.productRepository = productRepository;
        this.validationService = validationService;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = productRepository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

    public ProductEntity findProductById(Long id) {

        Optional<ProductEntity> productById = productRepository.findProductById(id);
        if (productById.isPresent()) {
            return productById.get();
        } else {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
    }
}
