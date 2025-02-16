package com.sahan.spring_ecommerce.controller;

import com.sahan.spring_ecommerce.model.Product;
import com.sahan.spring_ecommerce.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("Get all products called");
        List<Product> allProductsList = services.getAllProducts();
        if(allProductsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProductsList,HttpStatus.OK);
    }



}
