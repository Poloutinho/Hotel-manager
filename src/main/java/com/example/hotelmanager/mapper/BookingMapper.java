package com.example.hotelmanager.mapper;

import com.example.hotelmanager.config.MapperConfig;
import com.example.hotelmanager.dto.booking.BookingDto;
import com.example.hotelmanager.model.Booking;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookingMapper {

    BookingDto toDto(Booking booking);
}
