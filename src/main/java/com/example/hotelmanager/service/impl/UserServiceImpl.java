package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.dto.user.UserRegistrationRequestDto;
import com.example.hotelmanager.dto.user.UserResponseDto;
import com.example.hotelmanager.exception.RegistrationException;
import com.example.hotelmanager.mapper.UserMapper;
import com.example.hotelmanager.model.Role;
import com.example.hotelmanager.model.User;
import com.example.hotelmanager.repository.RoleRepository;
import com.example.hotelmanager.repository.UserRepository;
import com.example.hotelmanager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(@RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Guest with this email is already registered");
        }

        User guest = mapToUser(requestDto);
        User savedGuest = userRepository.save(guest);

        return userMapper.toResponseDto(savedGuest);
    }

    @Override
    public String addRole(Long userId, String roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("User with " + userId + " ID is not found"));

        Optional<Role.RoleName> roleNameEnumOpt = Arrays.stream(Role.RoleName.values())
                .filter(enumValue -> enumValue.name().equals(roleName))
                .findFirst();

        if (roleNameEnumOpt.isEmpty()) {
            throw new EntityNotFoundException("Role named " + roleName + " not found!");
        }

        Role.RoleName roleToAssign = Role.RoleName.valueOf(roleName);
        Role userRole = getRole(roleToAssign);

        if (user.getRoles().stream().anyMatch(role -> role.getName().equals(roleToAssign))) {
            return "User with " + userId + " already has the role " + roleName;
        }

        user.getRoles().add(userRole);
        userRepository.save(user);

        return "Role " + roleName + " for user with ID: " + userId + " successfully added!";
    }

    @Override
    public String removeRole(Long userId, String roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("User with " + userId + " ID is not found"));

        Optional<Role.RoleName> roleNameEnumOpt = Arrays.stream(Role.RoleName.values())
                .filter(enumValue -> enumValue.name().equals(roleName))
                .findFirst();

        if (roleNameEnumOpt.isEmpty()) {
            throw new EntityNotFoundException("Role named " + roleName + " not found!");
        }

        Role.RoleName roleToAssign = Role.RoleName.valueOf(roleName);
        Role userRole = getRole(roleToAssign);

        user.getRoles().remove(userRole);
        userRepository.save(user);

        return "Role " + roleName + " for user with ID: " + userId + " successfully removed!";
    }

    private User mapToUser(UserRegistrationRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setPhone(requestDto.getPhone());
        Role userRole = getRole(Role.RoleName.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        return user;
    }

    private Role getRole(Role.RoleName roleName) {
        return roleRepository.findByName(roleName).get();
    }
}
