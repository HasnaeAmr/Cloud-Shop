package com.shs.SHS.Ecommerce.mapper;

import com.shs.SHS.Ecommerce.dto.UserDto;
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
}
