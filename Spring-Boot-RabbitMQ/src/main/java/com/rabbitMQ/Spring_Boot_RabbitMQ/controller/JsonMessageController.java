package com.rabbitMQ.Spring_Boot_RabbitMQ.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitMQ.Spring_Boot_RabbitMQ.dto.Employee;
import com.rabbitMQ.Spring_Boot_RabbitMQ.producer.JsonMessageProducer;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

	@Autowired
	private JsonMessageProducer jsonMessageProducer; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);
	
	@GetMapping("up")
	public ResponseEntity<String> up(){
		return ResponseEntity.ok("Server is up !!");
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJSONMessage(@RequestBody Employee emp) {
		jsonMessageProducer.sendJsonMessage(emp);
		LOGGER.info(String.format("Json Payload sent -> %s", emp.toString()));
		return ResponseEntity.ok("Message has been produced !!");
	}
}
