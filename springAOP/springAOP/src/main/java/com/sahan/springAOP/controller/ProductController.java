package com.sahan.springAOP.controller;



import com.sahan.springAOP.model.Product;
import com.sahan.springAOP.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductServices services;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProductsList = services.getAllProducts();
        if(allProductsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProductsList,HttpStatus.OK);
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product searchedProduct = services.getProductById(id);
        if(searchedProduct.getId()!=-1){
            return new ResponseEntity<>(searchedProduct,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedProduct = null;
        try {
             savedProduct = services.addOrUpdateProduct(product,imageFile);
             return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        } catch (IOException e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImagewithProduct(@PathVariable("productId") int id){
        Product product =null;
        product = services.getProductById(id);
        if(product.getId()>0){
            return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateById(@RequestPart Product product, @RequestPart MultipartFile imageFile){

            try {
               Product updatedProduct =  services.addOrUpdateProduct(product,imageFile);
                return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = services.getProductById(id);
        if (product != null) {
            services.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = services.searchProducts(keyword);
        System.out.println("searching with :" + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
