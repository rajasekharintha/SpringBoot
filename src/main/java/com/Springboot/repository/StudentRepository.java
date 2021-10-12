package com.Springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.model.Students;




@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {


	
	List<Students> findByName(String name);

	List<Students> findBySurName(String surName);

	List<Students> findByPincode(String pincode);
	
}