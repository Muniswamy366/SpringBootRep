package com.arya.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arya.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "topictest";

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {

		kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

		return "Published successfully";
	}
}