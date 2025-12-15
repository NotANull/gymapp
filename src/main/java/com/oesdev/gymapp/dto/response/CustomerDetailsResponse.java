package com.oesdev.gymapp.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CustomerDetailsResponse {

    private Long id;
    private MembershipDetailsResponse membership;
    private List<RoutineDetailsResponse> assignedRoutines;
    private UserDetailsResponse user;

}
