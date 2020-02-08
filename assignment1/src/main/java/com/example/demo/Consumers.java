package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.request.RequestPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumers {
	
	@RabbitListener(queues = Configs.topicQueue)
	public void topicConsumer(RequestPOJO request) {
		printResponse(request, Configs.topicQueue);
	}
	
	@RabbitListener(queues = Configs.directQueue)
	public void directConsumer(RequestPOJO request) {
		printResponse(request, Configs.directQueue);
	}
	
	@RabbitListener(queues = Configs.fanoutQueue1)
	public void fanoutConsumer1(RequestPOJO request) {
		printResponse(request, Configs.fanoutQueue1);
	}
	
	@RabbitListener(queues = Configs.fanoutQueue2)
	public void fanoutConsumer2(RequestPOJO request) {
		printResponse(request, Configs.fanoutQueue2);
	}
	
	@RabbitListener(queues = Configs.fanoutQueue3)
	public void fanoutConsumer3(RequestPOJO request) {
		printResponse(request, Configs.fanoutQueue3);
	}
	
	private void printResponse(RequestPOJO request, String queueName) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Recieved Message From RabbitMQ: Queue name: " 
				+ queueName
				+ ", input json: " + jsonString);
	}
}
