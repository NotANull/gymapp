package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<CustomerProfile, Long> {

    List<CustomerProfile> findAllByStatus(Status status);

}
