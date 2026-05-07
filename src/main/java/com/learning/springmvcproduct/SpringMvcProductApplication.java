package com.learning.springmvcproduct;

import com.learning.springmvcproduct.model.Product;
import com.learning.springmvcproduct.service.ProductService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringMvcProductApplication {

    public static void main(String[] args) {

        ProductService service = new ProductService();
        service.addProduct(new Product("Macbook Air", "Laptop", "Table", 2027));
        service.addProduct(new Product("HP", "Laptop", "Cupboard", 2025));
        service.addProduct(new Product("Iphone", "Phone", "Bag", 2022));
        service.addProduct(new Product("Lightning Cable", "Cable", "Table", 2023));
        service.addProduct(new Product("Macbook Pro", "Laptop", "Table", 2027));
        service.addProduct(new Product("Asus VivoBook", "Laptop", "Bag", 2029));

        List<Product> products = service.getAllProducts();
        System.out.println(products);
    }
}
