package com.learning.springmvcproduct.repository;

import com.learning.springmvcproduct.model.Product;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDb {

    Connection conn = null;

    public ProductDb() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc","root","root123");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String query = "insert into Product (name, type, place, warranty) values (?,?,?,?)";
        try{
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, product.getName());
            st.setString(2, product.getType());
            st.setString(3, product.getPlace());
            st.setInt(4, product.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from Product";
        try{
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProdsByPlace(String place) {
        List<Product> products = new ArrayList<>();
        String query = "select name,type,place,warranty from Product where place= ?";
        try{
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, place);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
