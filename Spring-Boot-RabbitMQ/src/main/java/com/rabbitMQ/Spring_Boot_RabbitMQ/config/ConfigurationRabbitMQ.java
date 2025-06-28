package com.rabbitMQ.Spring_Boot_RabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Queue;

// Spring boot autoconfiguration will automatically connect the Spring boot application with RabbitMQ

@Configuration
public class ConfigurationRabbitMQ {

	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueueName;
	
	@Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

	// Creating spring bean for queue (store json messages)
	@Bean
	public org.springframework.amqp.core.Queue createJSONQueue() {
		return new org.springframework.amqp.core.Queue(jsonQueueName);
	}
	
	// creating spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // Now binding the json queue with exchange using routing key
    @Bean
    public Binding jsonBinding(){
        return BindingBuilder
                .bind(createJSONQueue())
                .to(exchange())
                .with(routingJsonKey);
    }
	
	
}
