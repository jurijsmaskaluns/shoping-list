package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public Product save(Product product) {
        Product productCopy = new Product(productIdSequence++, product.getName(), product.getPrice(), product.getDiscount(), product.getCategory(), product.getDescription());
        productRepository.put(productCopy.getId(), productCopy);
        return productCopy;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.get(id);
    }
}
