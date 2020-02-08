package com.example.demo.case3;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqFanoutConfig {
	static final String exchangeName = "fanout-exchange";
	static final String queue1 = "fanout-queue-1";
	static final String queue2 = "fanout-queue-2";
	static final String queue3 = "fanout-queue-3";
	
	@Bean
	Queue fanoutQueue1() {
		return new Queue(queue1, false);
	}
	
	@Bean
	Queue fanoutQueue2() {
		return new Queue(queue2, false);
	}
	
	@Bean
	Queue fanoutQueue3() {
		return new Queue(queue3, false);
	}
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(exchangeName);
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
