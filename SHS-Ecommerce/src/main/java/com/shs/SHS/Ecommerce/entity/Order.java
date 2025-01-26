package com.shs.SHS.Ecommerce.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;

    @Column(name="created_at")

    private final LocalDateTime createdAt = LocalDateTime.now();

    //payment
}
