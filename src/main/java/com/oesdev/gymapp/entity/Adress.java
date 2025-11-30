package com.oesdev.gymapp.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Remove the Lombok annotations in case JPA/Hibernate fails. Generate getters, setters and constructors
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Adress {


    private String street;
    private String number;
    private String city;
    private String country;

}
