package com.example.hotelmanager.dto.room;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRoomRequestDto {
    @NotBlank
    @Min(0)
    private int quantityOfMembers;
    @Min(0)
    private int quantityOfSingleBed;
    @Min(0)
    private int quantityOfDoubleBed;
    @NotBlank
    private double area;
    private boolean personalBathroom;
    private boolean airConditioner;
    private boolean personalKitchen;
    @NotBlank
    private boolean available;
}
