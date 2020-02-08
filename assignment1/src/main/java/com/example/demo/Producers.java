package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.request.RequestPOJO;

@RestController
public class Producers {
	
	@Autowired
	private AmqpTemplate template1, template2, template3;
    
	@RequestMapping(value = "/case1/service", method = RequestMethod.POST)
    public String processService1(@RequestBody RequestPOJO request) {
		template1.convertAndSend(Configs.topicExchange, "exchange.case1.service1", request);

		return "Topic Exchange : Message sent to the RabbitMQ Successfully";
    }
	
	@RequestMapping(value = "/case2/service", method = RequestMethod.POST)
    public String processService2(@RequestBody RequestPOJO request) {
		template2.convertAndSend(Configs.directExchange, "exchange.direct", request);

		return "Direct Exchange : Message sent to the RabbitMQ Successfully";
    }
	
	@RequestMapping(value = "/case3/service", method = RequestMethod.POST)
    public String processService3(@RequestBody RequestPOJO request) {
		template3.convertAndSend(Configs.fanoutExchange, "", request);

		return "Fanout Exchange : Message sent to the RabbitMQ Successfully";
    }
}
