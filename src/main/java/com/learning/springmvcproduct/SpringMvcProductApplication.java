package com.learning.springmvcproduct;

import com.learning.springmvcproduct.model.Product;
import com.learning.springmvcproduct.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringMvcProductApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringMvcProductApplication.class, args);

        ProductService service = context.getBean(ProductService.class);
        List<Product> prods = service.getProductByPlace("Cupboard");
        for(Product p : prods){
            System.out.println(p);
        }
    }
}
