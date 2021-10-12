package com.Springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Springboot.model.Students;
import com.Springboot.repository.StudentRepository;



@Service
public class StudentService  {

	@Autowired
	private StudentRepository studentRepository;

	// POST Method to save single user
	public Students saveStudent(Students student) {
		return studentRepository.save(student);
	}

	// POST Method to save list of Users
	public List<Students> saveUsers(List<Students> users) {
		return studentRepository.saveAll(users);
	}

	// GET Method to fetch all users from Database
	public List<Students> getUsers() {
		return studentRepository.findAll();
	}

	// GET Method to search user by Id
	public Students getUserById(int id) {
		Optional<Students> user = studentRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("User is not found for the id : " + id);
	}

	// GET Method to search user by Name
	public List<Students> getUserByName(String name) {
		return studentRepository.findByName(name);
	}

	// GET Method to search user by SurName
	public List<Students> getUserBySurName(String surName) {
		return studentRepository.findBySurName(surName);
	}

	// GET Method to search user by Pin code
	public List<Students> getUserByPincode(String pincode) {
		return studentRepository.findByPincode(pincode);
	}
	// GET Method to sort user by Dob
	public List<Students> sortByDob(){
		return studentRepository.findAll(Sort.by("dob").descending());
	}
	public List<Students> sortByJoiningDate(){
		return studentRepository.findAll(Sort.by("joiningDate").descending());
	}

	// DELETE Method to delete user by Id
	public String deleteUser(int id) {
		studentRepository.deleteById(id);
		return "User removed !! " + id;
	}

	// PUT Method id to update
	public Students updateUser(Students user) {
		Students existingUser = studentRepository.findById(user.getId()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setSurName(user.getSurName());
		existingUser.setDob(user.getDob());
		existingUser.setJoiningDate(user.getJoiningDate());
		existingUser.setState(user.getState());
		existingUser.setPincode(user.getPincode());
		return studentRepository.save(existingUser);

	}
}