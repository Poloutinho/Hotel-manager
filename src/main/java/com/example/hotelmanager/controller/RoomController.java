package com.example.hotelmanager.controller;

import com.example.hotelmanager.dto.room.CreateRoomRequestDto;
import com.example.hotelmanager.dto.room.RoomDto;
import com.example.hotelmanager.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public RoomDto saveRoom(@RequestBody CreateRoomRequestDto requestDto) {
        return roomService.saveRoom(requestDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/all")
    public List<RoomDto> findAllAvailable() {
        return roomService.findAllAvailable();
    }

}
