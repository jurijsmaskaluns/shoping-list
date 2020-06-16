package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.service.validation.ProductPriceIsLess;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, ProductEntity> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        ProductEntity productEntityCopy = new ProductEntity(productIdSequence++, productEntity.getName(), productEntity.getPrice(), productEntity.getDiscount(), productEntity.getCategory(), productEntity.getDescription());
        ProductPriceIsLess priceIsLess = new ProductPriceIsLess();
        ProductEntity pc = priceIsLess.validate(productEntityCopy);
        productRepository.put(pc.getId(), pc);
        return pc;
    }

    @Override
    public ProductEntity findProductById(Long id) {
        return productRepository.get(id);
    }
}
