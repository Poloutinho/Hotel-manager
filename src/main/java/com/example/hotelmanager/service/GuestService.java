package com.example.hotelmanager.service;

import com.example.hotelmanager.dto.guest.GuestRegistrationRequestDto;
import com.example.hotelmanager.dto.guest.GuestResponseDto;

public interface GuestService {
    GuestResponseDto register(GuestRegistrationRequestDto guest);
}
