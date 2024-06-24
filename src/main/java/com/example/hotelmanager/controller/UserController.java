package com.example.hotelmanager.controller;

import com.example.hotelmanager.dto.user.UserLoginRequestDto;
import com.example.hotelmanager.dto.user.UserLoginResponseDto;
import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import com.example.hotelmanager.exception.RegistrationException;
import com.example.hotelmanager.security.AuthenticationService;
import com.example.hotelmanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto)
            throws RegistrationException {
        return authenticationService.authenticate(requestDto);
    }
}
