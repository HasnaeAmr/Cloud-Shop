package com.shs.SHS.Ecommerce.repository;


import com.shs.SHS.Ecommerce.entity.Address;
import com.shs.SHS.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);

}