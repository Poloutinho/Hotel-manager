package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import com.example.hotelmanager.exception.RegistrationException;
import com.example.hotelmanager.mapper.UserMapper;
import com.example.hotelmanager.model.User;
import com.example.hotelmanager.repository.UserRepository;
import com.example.hotelmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(@RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Guest with this email is already registered");
        }

        User guest = mapToUser(requestDto);
        User savedGuest = userRepository.save(guest);

        return userMapper.toResponseDto(savedGuest);
    }

    private User mapToUser(UserRegistrationRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setPhone(requestDto.getPhone());
        return user;
    }
}
