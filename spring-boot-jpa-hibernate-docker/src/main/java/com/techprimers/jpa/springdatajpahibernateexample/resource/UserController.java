package com.techprimers.jpa.springdatajpahibernateexample.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserRepository usersRepository;

	public UserController(UserRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/getAll")
	public List<Users> all() {
		return usersRepository.findAll();
	}

	@PostMapping("/add")
	public List<Users> users(@RequestBody Users users) {
		/*
		 * Users users = new Users(); users.setId(1); users.setName("Sam");
		 * users.setSalary(3400);
		 */

		usersRepository.save(users);

		return usersRepository.findAll();
	}
}
