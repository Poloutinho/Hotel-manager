package com.example.hotelmanager.dto.booking;

import lombok.Data;

@Data
public class CreateBookingRequestDto {
    private Long roomId;
    private int durability;
}
