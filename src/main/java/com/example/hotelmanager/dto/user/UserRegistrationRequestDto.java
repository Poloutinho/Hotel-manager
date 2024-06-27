package com.example.hotelmanager.dto.user;

import com.example.hotelmanager.model.Role;
import com.example.hotelmanager.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRegistrationRequestDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String password;
    private String repeatPassword;
    private String phone;
    private Set<Role.RoleName> roles;
}
