package com.dj.practice.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	@GetMapping
	public String getUser() {
		return "Get user was called!";
	}
	
	@PostMapping
	public String createUser() {
		return "User was created!";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user!";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user!";
	}
}
