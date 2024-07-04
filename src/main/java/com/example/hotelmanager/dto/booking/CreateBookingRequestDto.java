package com.example.hotelmanager.dto.booking;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBookingRequestDto {
    @NotBlank
    private Long roomId;
    @NotBlank
    private int durability;
}
