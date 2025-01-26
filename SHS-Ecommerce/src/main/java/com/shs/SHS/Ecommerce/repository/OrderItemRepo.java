package com.shs.SHS.Ecommerce.repository;

import com.shs.SHS.Ecommerce.entity.Address;
import com.shs.SHS.Ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {

}
