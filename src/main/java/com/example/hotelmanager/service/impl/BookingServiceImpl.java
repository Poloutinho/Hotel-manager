package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.dto.booking.CreateBookingRequestDto;
import com.example.hotelmanager.exception.NoAccessToBookException;
import com.example.hotelmanager.mapper.BookingMapper;
import com.example.hotelmanager.model.Booking;
import com.example.hotelmanager.model.Room;
import com.example.hotelmanager.model.User;
import com.example.hotelmanager.repository.BookingRepository;
import com.example.hotelmanager.repository.RoomRepository;
import com.example.hotelmanager.service.BookingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomRepository roomRepository;

    @Override
    public BookingDto save(CreateBookingRequestDto requestDto, Authentication authentication) {
        Room roomToBook = roomRepository.findById(requestDto.getRoomId()).get();

        if (!roomToBook.isAvailable()) {
            throw new NoAccessToBookException("Can`t book this room, is already booked");
        }

        User user = (User)authentication.getPrincipal();
        Booking booking = new Booking();
        roomToBook.setAvailable(false);
        booking.setRoom(roomToBook);
        booking.setGuest(user);
        booking.setEndDate(booking.getStartDate().plusDays(requestDto.getDurability()));

        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll(Authentication authentication) {
        User user = (User)authentication.getPrincipal();

        return bookingRepository.findAll().stream()
                .filter(booking -> booking.getGuest().getId().equals(user.getId()))
                .map(bookingMapper::toDto)
                .toList();
    }
}
