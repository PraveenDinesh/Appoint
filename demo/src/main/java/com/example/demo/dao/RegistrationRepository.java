package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	boolean existsByEmail(String email);

}
