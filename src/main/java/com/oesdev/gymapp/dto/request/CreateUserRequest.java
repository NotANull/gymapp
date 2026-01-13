package com.oesdev.gymapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class CreateUserRequest {

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastname;

    @Pattern(regexp = "^[0-9]{7,8}$", message = "El DNI debe tener solo números (7 a 8 dígitos)")
    @NotBlank
    private String dni;

    @Size(min = 5, message = "El nombre de usuario debe tener 5 o más carácteres")
    @NotBlank
    private String username;

    @Size(min = 7, max = 20)
    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$")
    @NotBlank
    private String phoneNumber;

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$")
    private String emergencyPhoneNumber;

    @Valid
    @NotNull
    private CreateAddressRequest address;

}
