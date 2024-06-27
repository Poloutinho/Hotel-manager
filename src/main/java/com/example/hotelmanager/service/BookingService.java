package com.example.hotelmanager.service;

import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.dto.booking.CreateBookingRequestDto;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface BookingService {
    BookingDto save(CreateBookingRequestDto requestDto, Authentication authentication);

    List<BookingDto> findAll(Authentication authentication);
}
