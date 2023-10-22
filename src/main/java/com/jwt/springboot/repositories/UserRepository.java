package com.jwt.springboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
public Optional<User> findByEmail(String email);
}
