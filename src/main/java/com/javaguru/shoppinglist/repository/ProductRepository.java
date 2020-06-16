package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

public interface ProductRepository {
    ProductEntity save(ProductEntity productEntity);

    ProductEntity findProductById(Long id);


}
