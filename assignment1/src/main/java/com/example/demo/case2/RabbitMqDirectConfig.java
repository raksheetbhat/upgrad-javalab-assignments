package com.example.demo.case2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectConfig {
	static final String exchangeName = "direct-exchange";
	static final String queueName = "direct-queue";

	@Bean
	Queue directQueue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange directExchange() {
	    return new DirectExchange(exchangeName);
	}

	@Bean
	Binding directBinding(Queue directQueue, DirectExchange directExchange) {
	    return BindingBuilder.bind(directQueue).to(directExchange).with("exchange.direct");
	}
}
