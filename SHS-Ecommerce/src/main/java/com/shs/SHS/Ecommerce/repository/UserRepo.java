package com.shs.SHS.Ecommerce.repository;

import com.shs.SHS.Ecommerce.entity.Order;
import com.shs.SHS.Ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    static Optional<User> findByEmail(String email) {
        return null;
    }
}
