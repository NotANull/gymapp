package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.entity.*;
import com.oesdev.gymapp.enums.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public CustomerProfile toCustomerProfile(CreateCustomerRequest request) {

        CustomerProfile customer = new CustomerProfile();

        Address address = new Address();
        address.setStreet(request.getUser().getAddress().getStreet());
        address.setNumber(request.getUser().getAddress().getNumber());
        address.setCity(request.getUser().getAddress().getCity());
        address.setCountry(request.getUser().getAddress().getCountry());

        User user = new User(); //✔
        user.setName(request.getUser().getName());
        user.setLastname(request.getUser().getLastname());
        user.setDni(request.getUser().getDni());
        user.setUsername(request.getUser().getUsername());
        user.setPassword(request.getUser().getPassword());
        user.setEmail(request.getUser().getEmail());
        user.setPhoneNumber(request.getUser().getPhoneNumber());
        user.setEmergencyPhoneNumber(request.getUser().getEmergencyPhoneNumber());
        user.setAdress(address);

        Membership membership = new Membership(); //✔
        membership.setPlanName(request.getMembership().getPlanName());
        membership.setPrice(request.getMembership().getPrice());
        membership.setStatus(Status.ACTIVE); //When a customer is created, the status starts as ACTIVE


        customer.setMembership(membership);
        customer.setEnrollmentDate(LocalDate.now());
        customer.setUser(user);
        return customer;
    }

}
