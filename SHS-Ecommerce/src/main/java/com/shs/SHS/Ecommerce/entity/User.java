package com.shs.SHS.Ecommerce.entity;

import com.shs.SHS.Ecommerce.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="users")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="nAME is required")
    @Column(name="name")
    private String name;

    @Column(unique=true)
    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message="Password is required")
    private String password;

    @Column(name="phone_number")
    @NotBlank(message="Phone number is required")
    private String phoneNumber;

    private UserRole role;

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    private final LocalDateTime createdAt = LocalDateTime.now();

}
