package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMembershipRepository extends JpaRepository<Membership, Long> {
}
