package com.example.hotelmanager.service;

import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.dto.booking.CreateBookingRequestDto;
import org.springframework.security.core.Authentication;

public interface BookingService {
    BookingDto save(CreateBookingRequestDto requestDto, Authentication authentication);
}
