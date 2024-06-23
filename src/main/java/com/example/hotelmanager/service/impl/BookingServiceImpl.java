package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.dto.booking.CreateBookingRequestDto;
import com.example.hotelmanager.exception.NoAccessToBookException;
import com.example.hotelmanager.mapper.BookingMapper;
import com.example.hotelmanager.mapper.RoomMapper;
import com.example.hotelmanager.mapper.UserMapper;
import com.example.hotelmanager.model.Booking;
import com.example.hotelmanager.model.Room;
import com.example.hotelmanager.model.User;
import com.example.hotelmanager.repository.BookingRepository;
import com.example.hotelmanager.repository.RoomRepository;
import com.example.hotelmanager.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    private final UserMapper userMapper;
    private final RoomMapper roomMapper;

    @Override
    public BookingDto save(CreateBookingRequestDto requestDto, Authentication authentication) {
        User guest = (User) authentication.getPrincipal();
        Room roomToBook = roomRepository.findById(requestDto.getRoomId()).get();

        if (!roomToBook.isAvailable()) {
            throw new NoAccessToBookException("Can`t book this room, is already booked");
        }

        Booking booking = new Booking();
        booking.setRoom(roomToBook);
        booking.setGuest(guest);
        booking.setEndDate(booking.getStartDate().plusDays(requestDto.getDurability()));

        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }
}
