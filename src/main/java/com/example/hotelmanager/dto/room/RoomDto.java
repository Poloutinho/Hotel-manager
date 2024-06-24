package com.example.hotelmanager.dto.room;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private int quantityOfMembers;
    private int quantityOfSingleBed;
    private int quantityOfDoubleBed;
    private double area;
    private boolean personalBathroom;
    private boolean airConditioner;
    private boolean personalKitchen;
    private boolean available;
}
