package com.oesdev.gymapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UpdateUserRequest {

    private String name;

    private String lastname;

    private String username;

    private String password;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$")
    private String phoneNumber;

    @Pattern(regexp = "^\\+?[0-9\\s\\-()]{7,20}$")
    private String emergencyPhoneNumber;

    @Valid
    private UpdateAddressRequest address;

}
