package com.example.demo.case2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.RequestPOJO;

@RestController
public class DirectService {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
    
	@RequestMapping(value = "/case2/service", method = RequestMethod.POST)
    public String processRequest(@RequestBody RequestPOJO request) {
		amqpTemplate.convertAndSend(RabbitMqDirectConfig.exchangeName, "exchange.direct", request);

		return "Message sent to the RabbitMQ Successfully";
    }
}
