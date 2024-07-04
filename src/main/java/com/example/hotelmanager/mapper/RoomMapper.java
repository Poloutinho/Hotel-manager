package com.example.hotelmanager.mapper;

import com.example.hotelmanager.config.MapperConfig;
import com.example.hotelmanager.dto.room.CreateRoomRequestDto;
import com.example.hotelmanager.dto.room.RoomDto;
import com.example.hotelmanager.model.Room;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface RoomMapper {
    RoomDto toDto(Room room);

    Room toModel(CreateRoomRequestDto requestDto);
}
