package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductFieldException;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final ProductService service = new ProductService();


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                int userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product discount: ");
                        Integer discount = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        ProductDto dto = new ProductDto();
                        dto.setName(name);
                        dto.setCategory(category);
                        dto.setPrice(price);
                        dto.setDiscount(discount);
                        dto.setDescription(description);
                        ProductDto productDto = service.save(dto);
                        System.out.println("Product successfully created" + productDto);
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        ProductEntity productEntity1 = service.findProductById(id);
                        System.out.println("Product found: " + productEntity1);
                        break;
                    case 3:
                        return;
                }
            } catch (ProductFieldException e) {
                System.out.println("Product validation failed. Message: " + e.getMessage());
            } catch (ProductValidationException e) {
                System.out.println("Product validation failed. Message: " + e.getMessage());
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }
}
