package com.shs.SHS.Ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private String token;
    private String role;
    private String expirationTime;
    private long totalElement;

    private AddressDto address;

    private UserDto user;
    private List<UserDto> users;

    private CategoryDto category;
    private List<CategoryDto> categories;

    private ProductDto product;
    private List<ProductDto> products;

    private OrderDto order;
    private List<OrderDto> orders;

    private OrderItemDto orderItem;
    private List<OrderItemDto> orderItems;
}
