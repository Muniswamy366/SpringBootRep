package com.stu.jpa.cassandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stu.jpa.cassandra.entity.Customer;
import com.stu.jpa.cassandra.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(path = "/{firstName}")
	public List<Customer> listProducts(@PathVariable String firstName) {
		List<Customer> findByFirstname = customerRepository.findByFirstname(firstName);
		return findByFirstname;
	}

}
