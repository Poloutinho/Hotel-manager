package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.room.CreateRoomRequestDto;
import com.example.hotelmanager.dto.room.RoomDto;
import com.example.hotelmanager.mapper.RoomMapper;
import com.example.hotelmanager.model.Room;
import com.example.hotelmanager.repository.RoomRepository;
import com.example.hotelmanager.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDto saveRoom(CreateRoomRequestDto requestDto) {
        Room room = roomMapper.toModel(requestDto);
        roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    @Override
    public List<RoomDto> findAllAvailable() {
        List<Room> rooms = roomRepository.findAll();
        rooms.removeIf(room -> !room.isAvailable());

        return rooms.stream()
                .map(roomMapper::toDto)
                .toList();
    }
}
