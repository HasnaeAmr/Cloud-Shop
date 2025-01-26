package com.shs.SHS.Ecommerce.repository;

import com.shs.SHS.Ecommerce.entity.Address;
import com.shs.SHS.Ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
