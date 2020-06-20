package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.Optional;

public interface ProductRepository {
    ProductEntity save(ProductEntity productEntity);

    Optional<ProductEntity> findProductById(Long id);

    Optional<ProductEntity> findProductName(String name);


}
