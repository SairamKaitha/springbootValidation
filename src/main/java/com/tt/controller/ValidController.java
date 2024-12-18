package com.tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tt.model.User;
import com.tt.repo.ValidRepository;

import jakarta.validation.Valid;

@RestController
public class ValidController {

	@Autowired
	private ValidRepository repo;
	
	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user) {
		return repo.save(user);
	}
	
	@GetMapping("/fetch")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
}
