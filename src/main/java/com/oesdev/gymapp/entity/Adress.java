package com.oesdev.gymapp.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

//Remove the Lombok annotations in case JPA/Hibernate fails. Generate getters, setters and constructors
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Embeddable
public class Adress {

    private String street;
    private String number;
    private String city;
    private String country;

}
