package com.example.hotelmanager.mapper;

import com.example.hotelmanager.config.MapperConfig;
import com.example.hotelmanager.dto.guest.GuestRegistrationRequestDto;
import com.example.hotelmanager.dto.guest.GuestResponseDto;
import com.example.hotelmanager.model.Guest;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface GuestMapper {
    GuestResponseDto toResponseDto(Guest guest);

    Guest toModel(GuestRegistrationRequestDto guestRegistrationRequestDto);
}
