package com.shs.SHS.Ecommerce.repository;

import com.shs.SHS.Ecommerce.entity.Address;
import com.shs.SHS.Ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
