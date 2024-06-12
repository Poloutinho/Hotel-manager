package com.example.hotelmanager.controller;

import com.example.hotelmanager.dto.guest.GuestRegistrationRequestDto;
import com.example.hotelmanager.dto.guest.GuestResponseDto;
import com.example.hotelmanager.service.GuestService;
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
public class GuestController {
    private final GuestService guestService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public GuestResponseDto register(@RequestBody @Valid GuestRegistrationRequestDto requestDto) {
        return guestService.register(requestDto);
    }
}
