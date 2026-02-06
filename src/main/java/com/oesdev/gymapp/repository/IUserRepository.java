package com.oesdev.gymapp.repository;

import com.oesdev.gymapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDni(String dni);

}
