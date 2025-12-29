package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerProfile, Long> {
}
