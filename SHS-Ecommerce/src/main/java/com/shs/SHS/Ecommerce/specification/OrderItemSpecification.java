package com.shs.SHS.Ecommerce.specification;

import com.shs.SHS.Ecommerce.entity.OrderItem;
import com.shs.SHS.Ecommerce.enums.OrderStatus;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDateTime;

public class OrderItemSpecification {

    public static Specification<OrderItem> hasStatus(OrderStatus status) {
        return ((root, query, criteriaBuilder) -> status != null ? criteriaBuilder
                .equal(root.get("status"),status) : null);
    }
    public static Specification<OrderItem> createBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return ((root, query, criteriaBuilder) -> {
            if(startDate != null && endDate != null) {
                return criteriaBuilder.between(root.get("createdAt"),startDate,endDate);
            }else if(startDate != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"),startDate);
            }else if(endDate != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"),endDate);
            }else
                return null;
        });

    }
    public static Specification<OrderItem> hasItemId(Long itemId) {
        return ((root, query, criteriaBuilder) ->
                itemId != null ? criteriaBuilder.equal(root.get("itemId"),itemId) : null);
    }
}
