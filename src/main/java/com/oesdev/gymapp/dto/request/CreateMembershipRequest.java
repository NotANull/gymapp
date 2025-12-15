package com.oesdev.gymapp.dto.request;

import com.oesdev.gymapp.enums.PlanType;
import com.oesdev.gymapp.enums.Status;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateMembershipRequest {

    private PlanType planName;

    private double price;

    private LocalDate enrollmentDate;

    private Status status;

}
