package com.oesdev.gymapp.dto.response;

import com.oesdev.gymapp.enums.PlanType;
import com.oesdev.gymapp.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class MembershipDetailsResponse {

    private Long id;
    private PlanType planName;
    private BigDecimal price;

}
