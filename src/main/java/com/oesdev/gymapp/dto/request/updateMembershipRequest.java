package com.oesdev.gymapp.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class updateMembershipRequest {

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

}
