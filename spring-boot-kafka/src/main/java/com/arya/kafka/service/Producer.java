package com.arya.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.arya.kafka.model.User;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "topictest";

	public void sendMessage(User user) {
		logger.info(String.format("#### -> Producing message -> %s", user));
		this.kafkaTemplate.send(TOPIC, user);
	}
}