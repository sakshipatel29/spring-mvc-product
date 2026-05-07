package com.learning.springmvcproduct.service;

import com.learning.springmvcproduct.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getAllProducts(){
        return products;
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
        List<Product> prods = new ArrayList<>();
        for(Product p : products){
            if(p.getPlace().equals(place)){
                prods.add(p);
            }
        }
        return prods;
    }
}
