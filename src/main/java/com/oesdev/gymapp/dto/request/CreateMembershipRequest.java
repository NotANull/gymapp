package com.oesdev.gymapp.dto.request;

import com.oesdev.gymapp.enums.PlanType;
import com.oesdev.gymapp.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateMembershipRequest {

    @NotNull
    private PlanType planName;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @PastOrPresent
    private LocalDate enrollmentDate;

    @NotNull
    private Status status;

}
