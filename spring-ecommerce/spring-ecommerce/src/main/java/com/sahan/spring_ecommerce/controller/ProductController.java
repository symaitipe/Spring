package com.sahan.spring_ecommerce.controller;

import com.sahan.spring_ecommerce.model.Product;
import com.sahan.spring_ecommerce.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    ProductServices services;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        //System.out.println("Get all products called");
        return services.getAllProducts();
    }



}
