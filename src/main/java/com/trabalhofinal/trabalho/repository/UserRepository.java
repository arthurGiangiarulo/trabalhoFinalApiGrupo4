package com.trabalhofinal.trabalho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.trabalho.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUserEmail(String email);
}