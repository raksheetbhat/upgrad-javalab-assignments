package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public class Configs {
	static final String topicExchange = "topic-exchange";
	static final String topicQueue = "topic-queue";
	
	static final String directExchange = "direct-exchange";
	static final String directQueue = "direct-queue";
	
	static final String fanoutExchange = "fanout-exchange";
	static final String fanoutQueue1 = "fanout-queue-1";
	static final String fanoutQueue2 = "fanout-queue-2";
	static final String fanoutQueue3 = "fanout-queue-3";

	@Bean
	Queue topicQueue() {
		return new Queue(topicQueue, false);
	}

	@Bean
	TopicExchange topicExchange() {
	    return new TopicExchange(topicExchange);
	}

	@Bean
	Binding topicBinding(Queue topicQueue, TopicExchange topicExchange) {
	    return BindingBuilder.bind(topicQueue).to(topicExchange).with("exchange.#");
	}

	@Bean
	Queue directQueue() {
		return new Queue(directQueue, false);
	}

	@Bean
	DirectExchange directExchange() {
	    return new DirectExchange(directExchange);
	}

	@Bean
	Binding directBinding(Queue directQueue, DirectExchange directExchange) {
	    return BindingBuilder.bind(directQueue).to(directExchange).with("exchange.direct");
	}
	
	@Bean
	Queue fanoutQueue1() {
		return new Queue(fanoutQueue1, false);
	}
	
	@Bean
	Queue fanoutQueue2() {
		return new Queue(fanoutQueue2, false);
	}
	
	@Bean
	Queue fanoutQueue3() {
		return new Queue(fanoutQueue3, false);
	}
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(fanoutExchange);
	}
	
	@Bean
	Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
	    return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
	}
	
	@Bean
	Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
	    return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
	}
	
	@Bean
	Binding fanoutBinding3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
	    return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
	}
}
