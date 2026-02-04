package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfessorRepository extends JpaRepository<ProfessorProfile, Long> {

    List<ProfessorProfile> findAllByStatus(Status status);

}
