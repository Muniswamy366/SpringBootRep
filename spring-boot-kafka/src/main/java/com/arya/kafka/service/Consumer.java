package com.arya.kafka.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.arya.kafka.model.User;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@KafkaListener(topics = "topictest", groupId = "group_id")
	public void consume(User user) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", user));
	}
}