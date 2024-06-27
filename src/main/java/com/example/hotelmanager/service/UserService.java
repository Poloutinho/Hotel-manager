package com.example.hotelmanager.service;

import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);

    String addRole(Long userId, String roleName);

    String removeRole(Long userId, String roleName);
}
