package com.sahan.spring_ecommerce.service;

import com.sahan.spring_ecommerce.model.Product;
import com.sahan.spring_ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepo repo;
    public List<Product> getAllProducts() {
       return repo.findAll();
    }

    public String addProduct(Product product){
        repo.save(product);
        return "Success";
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product(-1));
    }
}
