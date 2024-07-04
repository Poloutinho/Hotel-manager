package com.example.hotelmanager.mapper;

import com.example.hotelmanager.config.MapperConfig;
import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import com.example.hotelmanager.model.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    UserResponseDto toResponseDto(User user);

    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    User toUser(UserRegistrationRequestDto requestDto, @Context PasswordEncoder passwordEncoder);

    @Named("encodePassword")
    default String encodePassword(String password, @Context PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(password);
    }
}
