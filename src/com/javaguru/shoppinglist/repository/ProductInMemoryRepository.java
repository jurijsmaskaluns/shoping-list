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
        if(product.getPrice().intValue() <20 ){
            Product productCopy1 = new Product(productCopy.getId(),productCopy.getName(), productCopy.getPrice(), 0, productCopy.getCategory(),productCopy.getDescription());
            return productCopy1;
        }
        productRepository.put(productCopy.getId(), productCopy);
        return productCopy;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.get(id);
    }
}
