package com.oesdev.gymapp.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateAddressRequest {

    private String street;
    private String number;
    private String city;
    private String country;

}
