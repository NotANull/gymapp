package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoutineRepository extends JpaRepository<Routine, Long> {
}
