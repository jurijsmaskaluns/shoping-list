package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        while (name.length()<3 || name.length()> 32){
                            System.out.println("название не может быть меньше 3 символов и больше 32");
                            name = scanner.nextLine();
                        }
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        while (price.intValue()<=0){
                            System.out.println("цена продукта должна быть больше 0");
                            price = new BigDecimal(scanner.nextLine());
                        }
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product discount: ");
                        Integer discount = Integer.parseInt(scanner.nextLine());
                        while (discount<0 || discount>100){
                            System.out.println("скидка не может быть больше 100 процентов и меньше 0");
                            discount = Integer.parseInt(scanner.nextLine());
                        }
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result(id): " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
