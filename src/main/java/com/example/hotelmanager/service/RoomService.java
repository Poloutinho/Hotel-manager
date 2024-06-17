package com.example.hotelmanager.service;

import com.example.hotelmanager.dto.room.CreateRoomRequestDto;
import com.example.hotelmanager.dto.room.RoomDto;
import java.util.List;

public interface RoomService {
    RoomDto saveRoom(CreateRoomRequestDto room);

    List<RoomDto> findAllAvailable();
}
