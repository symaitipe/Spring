package com.sahan.spring_ecommerce.repo;

import com.sahan.spring_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
