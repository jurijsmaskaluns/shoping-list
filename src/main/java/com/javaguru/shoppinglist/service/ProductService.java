package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private ProductInMemoryRepository productRepository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();
    private BeanMapper beanMapper = new BeanMapper();

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = productRepository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

    public ProductEntity findProductById(Long id) {
        ProductEntity productEntity = productRepository.findProductById(id);
        if (productEntity != null) {
            return productEntity;
        } else {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
    }
}
