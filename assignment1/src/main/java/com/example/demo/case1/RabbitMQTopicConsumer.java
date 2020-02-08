package com.example.demo.case1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.request.RequestPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQTopicConsumer {

	@RabbitListener(queues = "#{topicQueue.name}")
	public void recievedMessage(RequestPOJO request) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Recieved Message From RabbitMQ: Queue name: " 
				+ RabbitMqTopicConfig.queueName
				+ ", routing key: " + "exchange.case1.service1"
				+ ", input json: " + jsonString);
	}
}
