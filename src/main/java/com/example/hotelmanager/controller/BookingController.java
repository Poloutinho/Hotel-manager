package com.example.hotelmanager.controller;

import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.dto.booking.CreateBookingRequestDto;
import com.example.hotelmanager.service.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;

    @PreAuthorize("ROLE_USER")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto save(@RequestBody @Valid CreateBookingRequestDto requestDto,
                           Authentication authentication) {
        return bookingService.save(requestDto, authentication);
    }

    @PreAuthorize("ROLE_USER")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDto> findAll(Authentication authentication) {
        return bookingService.findAll(authentication);
    }
}
