package com.rabbitMQ.Spring_Boot_RabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitMqApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRabbitMqApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args);
		LOGGER.info(String.format("Applications is started :: %s", "Rabbit MQ messaging Queue is initialized !!!"));
		System.out.println("Rabbit MQ messaging Queue is initialized !!!");
	}

}
