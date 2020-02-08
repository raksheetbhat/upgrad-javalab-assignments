package com.example.demo.case3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.request.RequestPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQFanoutConsumers {

	@RabbitListener(queues = "#{fanoutQueue1.name}")
	public void receiveMsgQueue1(RequestPOJO request) {
		printVal(request, RabbitMqFanoutConfig.queue1);
	}
	
	@RabbitListener(queues = "#{fanoutQueue2.name}")
	public void receiveMsgQueue2(RequestPOJO request) {
		printVal(request, RabbitMqFanoutConfig.queue2);
	}
	
	@RabbitListener(queues = "#{fanoutQueue3.name}")
	public void receiveMsgQueue3(RequestPOJO request) {
		printVal(request, RabbitMqFanoutConfig.queue3);
	}
	
	private void printVal(RequestPOJO request, String queueName) {
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
