package com.example.hotelmanager.repository;

import com.example.hotelmanager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
