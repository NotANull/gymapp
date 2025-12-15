package com.oesdev.gymapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateAddressRequest {

    @NotBlank
    @Size(min = 1, max = 50)
    private String street;

    @NotBlank
    @Size(min = 1, max = 50)
    private String number;

    @NotBlank
    @Size(min = 1, max = 50)
    private String city;

    @NotBlank
    @Size(min = 1, max = 50)
    private String country;

}
