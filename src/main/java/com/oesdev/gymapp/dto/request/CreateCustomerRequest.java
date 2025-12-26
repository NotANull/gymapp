package com.oesdev.gymapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateCustomerRequest {

    @NotNull
    private CreateMembershipRequest membership;

    @Valid
    @NotNull
    private CreateUserRequest user;

}
