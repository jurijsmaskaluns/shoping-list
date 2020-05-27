package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private final ProductRepository productRepository = new ProductInMemoryRepository();
    private final ProductValidationService validationService = new ProductValidationService();

    public Product save(Product product) {
        validationService.validate(product);
        return productRepository.save(product);
    }

    public Product findProductById(Long id) {
        Product product = productRepository.findProductById(id);
        if (product != null) {
            return product;
        } else {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
    }
}
