package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceIsLess {
    public Product validate(Product product) {
        if (product.getPrice().intValue() < 20) {
            Product productCopy = new Product(product.getId(), product.getName(), product.getPrice(), 0, product.getCategory(), product.getDescription());
            return productCopy;
        }
        return product;
    }
}
