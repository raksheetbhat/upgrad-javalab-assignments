package com.example.demo.case1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.RequestPOJO;

@RestController
public class TopicService {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
    
	@RequestMapping(value = "/case1/service", method = RequestMethod.POST)
    public String processRequest(@RequestBody RequestPOJO request) {
		amqpTemplate.convertAndSend(RabbitMqTopicConfig.exchangeName, "exchange.case1.service1", request);

		return "Message sent to the RabbitMQ Successfully";
    }
}
