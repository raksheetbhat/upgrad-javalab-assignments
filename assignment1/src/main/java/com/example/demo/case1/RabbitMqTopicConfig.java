package com.example.demo.case1;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {
	static final String exchangeName = "topic-exchange";
	static final String queueName = "topic-queue";

	@Bean
	Queue topicQueue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange topicExchange() {
	    return new TopicExchange(exchangeName);
	}

	@Bean
	Binding topicBinding(Queue topicQueue, TopicExchange topicExchange) {
	    return BindingBuilder.bind(topicQueue).to(topicExchange).with("exchange.#");
	}
}
