package com.sahan.spring_ecommerce.controller;

import com.sahan.spring_ecommerce.model.Product;
import com.sahan.spring_ecommerce.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product searchedProduct = services.getProductById(id);
        System.out.println("search by ID is called");
        if(searchedProduct.getId()!=-1){
            return new ResponseEntity<>(searchedProduct,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
