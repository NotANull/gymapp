package com.oesdev.gymapp.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class AddressDetailsResponse {

    private String street;
    private String number;
    private String city;
    private String country;

}
