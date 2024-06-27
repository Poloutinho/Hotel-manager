package com.example.hotelmanager.mapper;

import com.example.hotelmanager.config.MapperConfig;
import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import com.example.hotelmanager.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toResponseDto(User user);

    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);
}
