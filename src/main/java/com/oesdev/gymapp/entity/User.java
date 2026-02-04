package com.oesdev.gymapp.entity;

import com.oesdev.gymapp.enums.Role;
import com.oesdev.gymapp.enums.Status;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    @Column(unique = true)
    private String dni; //Unique

    @Column(unique = true)
    private String username; //Unique

    private String password;

    @Column(unique = true)
    private String email; //Unique

    private String phoneNumber;
    private String emergencyPhoneNumber;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active = true; //Only for allow or deny access

    public User() {}

    public User(String name, String lastname, String dni, String username, String email, String phoneNumber, String emergencyPhoneNumber, Address address, Set<Role> roles, boolean active) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        this.address = address;
        this.roles = roles;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(this.roles);
    }

    public void addRoles(Role role) {
        this.roles.add(role);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}