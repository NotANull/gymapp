package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
