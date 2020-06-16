package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;

public class ProductPriceIsLess {
    public ProductEntity validate(ProductEntity productEntity) {
        if (productEntity.getPrice().intValue() < 20) {
            ProductEntity productEntityCopy = new ProductEntity(productEntity.getId(), productEntity.getName(), productEntity.getPrice(), 0, productEntity.getCategory(), productEntity.getDescription());
            return productEntityCopy;
        }
        return productEntity;
    }
}
