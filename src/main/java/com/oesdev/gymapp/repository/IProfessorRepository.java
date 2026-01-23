package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.ProfessorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<ProfessorProfile, Long> {
}
