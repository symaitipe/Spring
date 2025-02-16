package com.sahan.spring_ecommerce.service;

import com.sahan.spring_ecommerce.model.Product;
import com.sahan.spring_ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepo repo;
    public List<Product> getAllProducts() {
       return repo.findAll();
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
      product.setImageName(imageFile.getOriginalFilename());
      product.setImageType(imageFile.getContentType());
      product.setImageData(imageFile.getBytes());

      return repo.save(product);
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product(-1));
    }

}
