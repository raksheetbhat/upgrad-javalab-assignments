//package com.example.demo;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.pojo.Request;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class Consumers {
//	
//	@RabbitListener(queues = Configs.topicQueue)
//	public void topicConsumer(Request request) {
//		printResponse(request, Configs.topicQueue);
//	}
//	
//	@RabbitListener(queues = Configs.directQueue)
//	public void directConsumer(Request request) {
//		printResponse(request, Configs.directQueue);
//	}
//	
//	@RabbitListener(queues = Configs.fanoutQueue1)
//	public void fanoutConsumer1(Request request) {
//		printResponse(request, Configs.fanoutQueue1);
//	}
//	
//	@RabbitListener(queues = Configs.fanoutQueue2)
//	public void fanoutConsumer2(Request request) {
//		printResponse(request, Configs.fanoutQueue2);
//	}
//	
//	@RabbitListener(queues = Configs.fanoutQueue3)
//	public void fanoutConsumer3(Request request) {
//		printResponse(request, Configs.fanoutQueue3);
//	}
//	
//	private void printResponse(Request request, String queueName) {
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonString = "";
//		try {
//			jsonString = mapper.writeValueAsString(request);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("Recieved Message From RabbitMQ: Queue name: " 
//				+ queueName
//				+ ", input json: " + jsonString + ", "+request);
//	}
//}
