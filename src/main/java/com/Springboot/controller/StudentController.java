package com.Springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.annotation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.model.Students;
import com.Springboot.service.StudentService;




@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addUser")
	public Students addStudent(@Valid @RequestBody Students student) {
		return studentService.saveStudent(student);
	}

	@PostMapping("/addUsers")
	public List<Students> addUser(@Valid @RequestBody List<Students> students) {
		return studentService.saveUsers(students);
	}

	@GetMapping("/users")
	public List<Students> findAllUsers() {
		return studentService.getUsers();
	}

	@GetMapping("/userById/{id}")
	public Students findUserById(@PathVariable int id) { 
		return studentService.getUserById(id);
	}

	@GetMapping("/userByName/{name}")
	public List<Students> findUserByName(@PathVariable String name) {
		return studentService.getUserByName(name);
	}

	@GetMapping("/userBySurName/{surName}")
	public List<Students> findUserBySurName(@PathVariable String surName) {
		return studentService.getUserBySurName(surName);
	}

	@GetMapping("/userByPincode/{pincode}")
	public List<Students> findUserByPincode(@PathVariable String pincode) {
		return studentService.getUserByPincode(pincode);
	}
	@GetMapping("/sortByDob")
	public List<Students> sortUserByDob(){
		return studentService.sortByDob();
	}
	@GetMapping("/sortByJoiningDate")
	public List<Students> sortUserByJoiningDate(){
		return studentService.sortByJoiningDate();
	}
	@PutMapping("/update")
	public Students updateUser(@RequestBody Students student) {
		return studentService.updateUser(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return studentService.deleteUser(id);
	}
}