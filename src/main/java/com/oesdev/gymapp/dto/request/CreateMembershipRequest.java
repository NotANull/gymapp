package com.oesdev.gymapp.dto.request;

import com.oesdev.gymapp.enums.PlanType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

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

}
