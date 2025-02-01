package com.shs.SHS.Ecommerce.mapper;

import com.shs.SHS.Ecommerce.dto.*;
import com.shs.SHS.Ecommerce.entity.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    //user entity to DTO
    public UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());
        userDto.setName(user.getName());
        return userDto;
    }

    //Address to DTO
    public AddressDto mapAddressToAddresDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    //Category to DTO
    public CategoryDto mapCategoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    //OrderItem to DTO
    public OrderItemDto mapOrderItemToOrderItemDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }

    // Product to DTO
    public ProductDto mapProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    public UserDto mapUserToDtoPlusAddress(User user){
        UserDto userDto = mapUserToUserDto(user);
        if(user.getAddress() != null){
            AddressDto addressDto = mapAddressToAddresDto(user.getAddress());
            userDto.setAddress(addressDto);
        }
        return userDto;
    }

    //orderitem to DTO plus product
    public OrderItemDto mapOrderItemDtoPlusProduct(OrderItem orderItem){
        OrderItemDto orderItemDto = mapOrderItemToOrderItemDto(orderItem);
        if(orderItem.getProduct() != null){
            ProductDto productDto = mapProductToProductDto(orderItem.getProduct());
            orderItemDto.setProduct(productDto);
        }
        return orderItemDto;
    }

    //OrderItem to DTO plus product and user
    public OrderItemDto mapOrderItemTotDtoPlusProductAndUser(OrderItem orderItem){
        OrderItemDto orderItemDto = mapOrderItemDtoPlusProduct(orderItem);

        if(orderItemDto.getUser() != null){
            UserDto userDto = mapUserToUserDto(orderItem.getUser());
            orderItemDto.setUser(userDto);
        }
        return orderItemDto;
    }

    //user to DTO with Address and Order Items History
    public UserDto mapUserToDtoPlusAddressAndOrderHistory(User user){
        UserDto userDto = mapUserToDtoPlusAddress(user);

        if(userDto.getOrderItemList() != null && !user.getOrderItemList().isEmpty()){
            userDto.setOrderItemList(user.getOrderItemList().stream()
                    .map(this::mapOrderItemDtoPlusProduct)
                    .collect(Collectors.toList()));
        }
        return userDto;
    }
}
