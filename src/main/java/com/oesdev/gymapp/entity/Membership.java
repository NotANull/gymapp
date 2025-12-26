package com.oesdev.gymapp.entity;

import com.oesdev.gymapp.enums.PlanType;
import com.oesdev.gymapp.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanType planName;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Status status;
}
