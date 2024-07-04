package com.example.hotelmanager.dto.booking;

import com.example.hotelmanager.dto.room.RoomDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BookingDto {
    private Long id;
    private RoomDto room;
    private UserResponseDto guest;
    private LocalDate startDate;
    private LocalDate endDate;
}
