package com.rabbitMQ.Spring_Boot_RabbitMQ.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitMQ.Spring_Boot_RabbitMQ.dto.Employee;

@Service
public class JsonMessageProducer {

	/* Message producer firstly fetch the values of Exhange and routing key from properties file
	 *  and send a message to queue by using sendAndConvert()
	 * */
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageProducer.class);
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("{rabbitmq.routing.json.key}")
	private String Routing_Key;
	
	// Dependency Injection
	@Autowired
	private RabbitTemplate rabbitTemplate; 
	
	
	public void sendJsonMessage(Employee emp){
        LOGGER.info(String.format("Json Payload sent -> %s", emp.toString()));
        //rabbitTemplate.convertAndSend(exchange, Routing_Key, emp);
    }
	
}
