package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.nosqldb.ProductCollection;
import com.example.demo.nosqldb.RequestCollection;
import com.example.demo.pojo.ProductPOJO;
import com.example.demo.pojo.RequestPOJO;
import com.example.demo.repos.RequestNosqlRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Consumer {
	
	@Autowired
	private RequestNosqlRepo repository;
	
	@RabbitListener(queues = Producer.directQueue)
	public void directConsumer(RequestPOJO request) {
		printResponse(request, Producer.directQueue);
		
		List<ProductCollection> list = new ArrayList<>();
		for(ProductPOJO pr : request.getProducts()) {
			list.add(new ProductCollection(pr.getName(), pr.getPrice()));
		}
		
		repository.save(new RequestCollection(request.getOrderId(), list));
		
		// fetch all customers
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
	    for (RequestCollection customer : repository.findAll()) {
	      System.out.println(customer);
	    }
	    System.out.println();
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
				+ ", input json: " + jsonString + ", "+request);
	}

}
