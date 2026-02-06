package com.oesdev.gymapp.dto.response;

import com.oesdev.gymapp.enums.Role;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UserDetailsResponse {

    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String phoneNumber;
    private String emergencyPhoneNumber;
    private AddressDetailsResponse address;
    private Set<Role> roles;
    private boolean active;

}
