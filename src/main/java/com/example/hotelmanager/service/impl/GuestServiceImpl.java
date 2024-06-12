package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.guest.GuestRegistrationRequestDto;
import com.example.hotelmanager.dto.guest.GuestResponseDto;
import com.example.hotelmanager.exception.RegistrationException;
import com.example.hotelmanager.mapper.GuestMapper;
import com.example.hotelmanager.model.Guest;
import com.example.hotelmanager.repository.GuestRepository;
import com.example.hotelmanager.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    @Override
    public GuestResponseDto register(@RequestBody GuestRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (guestRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Guest with this email is already registered");
        }

        Guest guest = mapToGuest(requestDto);
        Guest savedGuest = guestRepository.save(guest);

        return guestMapper.toResponseDto(savedGuest);
    }

    private Guest mapToGuest(GuestRegistrationRequestDto requestDto) {
        Guest guest = new Guest();
        guest.setEmail(requestDto.getEmail());
        guest.setFirstName(requestDto.getFirstName());
        guest.setLastName(requestDto.getLastName());
        guest.setPhone(requestDto.getPhone());
        return guest;
    }
}
