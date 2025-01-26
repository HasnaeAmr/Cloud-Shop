package com.shs.SHS.Ecommerce.entity;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String method;
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name="created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();
}
