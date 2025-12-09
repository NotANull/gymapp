package com.oesdev.gymapp.dto.request;

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
    private String dni; //Unique

    @Size(min = 5, message = "El nombre de usuario debe tener 5 o más carácteres")
    private String username; //Unique

    private String password;

    @NotBlank
    @Email
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email; //Unique

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$\n")
    private String phoneNumber;

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$\n")
    private String emergencyPhoneNumber;

    @NotNull
    private CreateAdressRequest adress;

}
