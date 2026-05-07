package com.learning.springmvcproduct.service;

import com.learning.springmvcproduct.model.Product;
import com.learning.springmvcproduct.repository.ProductDb;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDb db = new ProductDb();

    public void addProduct(Product product){
        db.save(product);
    }

    public List<Product> getAllProducts(){
        return db.getAllProducts();
    }

    public Product getProduct(String name){
        for(Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductByPlace(String place){
        return db.getProdsByPlace(place);

    }

    public List<Product> outOfWarranty(){
        List<Product> prods = new ArrayList<>();
        for(Product p : products){
            if(p.getWarranty() <= 2025){
                prods.add(p);
            }
        }
        return prods;
    }

    public List<Product> getProductsByText(String text){
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        return products.stream()
                .filter(p ->
                        (p.getName() != null && p.getName().toLowerCase().contains(str)) ||
                        (p.getType() != null && p.getType().toLowerCase().contains(str)) ||
                        (p.getPlace() != null && p.getPlace().toLowerCase().contains(str))
                )
                .toList();
    }
}
