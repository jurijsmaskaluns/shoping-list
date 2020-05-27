package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductRepository {
    Product save(Product product);

    Product findProductById(Long id);


}
