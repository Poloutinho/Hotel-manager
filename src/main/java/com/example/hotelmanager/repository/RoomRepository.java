package com.example.hotelmanager.repository;

import com.example.hotelmanager.model.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.isAvailable = true")
    List<Room> findAllAvailable();
}
