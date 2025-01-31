package com.shs.SHS.Ecommerce.mapper;

import com.shs.SHS.Ecommerce.dto.AddressDto;
import com.shs.SHS.Ecommerce.dto.CategoryDto;
import com.shs.SHS.Ecommerce.dto.UserDto;
import com.shs.SHS.Ecommerce.entity.Address;
import com.shs.SHS.Ecommerce.entity.Category;
import com.shs.SHS.Ecommerce.entity.User;
import org.springframework.stereotype.Component;

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
}
