package com.oesdev.gymapp.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UpdateCustomerRequest {

    private UpdateUserRequest user;

}
