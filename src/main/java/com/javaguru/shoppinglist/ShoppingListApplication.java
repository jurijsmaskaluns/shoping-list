package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.*;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository repository = new ProductInMemoryRepository();

        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();
        ProductValidationRule productDescriptionValidationRule = new ProductDescriptionValidationRule();
        ProductValidationRule productFieldValidationRule = new ProductFieldValidationRule();
        ProductValidationRule productNameLengthValidationRule = new ProductNameLengthValidationRule();
        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();
        ProductValidationRule productUniqueValidationRule = new ProductUniqueValidationRule(repository);
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productDescriptionValidationRule);
        rules.add(productDiscountValidationRule);
        rules.add(productFieldValidationRule);
        rules.add(productPriceValidationRule);
        rules.add(productNameLengthValidationRule);
        rules.add(productUniqueValidationRule);
        ProductValidationService validationService = new ProductValidationService(rules);

        BeanMapper beanMapper = new BeanMapper();


        ProductService service = new ProductService(repository, validationService, beanMapper);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();

    }
}
