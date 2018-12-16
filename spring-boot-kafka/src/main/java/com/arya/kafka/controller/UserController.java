package com.arya.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arya.kafka.model.User;
import com.arya.kafka.service.Producer;

@RestController
@RequestMapping("kafka")
public class UserController {

	@Autowired
	private Producer producer;

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {

		producer.sendMessage(new User(name, "Technology", 12000L));

		return "Published successfully";
	}
}