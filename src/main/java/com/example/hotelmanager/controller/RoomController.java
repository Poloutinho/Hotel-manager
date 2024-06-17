package com.example.hotelmanager.controller;

import com.example.hotelmanager.dto.room.CreateRoomRequestDto;
import com.example.hotelmanager.dto.room.RoomDto;
import com.example.hotelmanager.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/save")
    public RoomDto saveRoom(@RequestBody CreateRoomRequestDto requestDto) {
        return roomService.saveRoom(requestDto);
    }

    @GetMapping("/all")
    public List<RoomDto> findAllAvailable() {
        return roomService.findAllAvailable();
    }

}
