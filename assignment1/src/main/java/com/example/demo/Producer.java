package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ProductPOJO;
import com.example.demo.pojo.RequestPOJO;
//import com.example.demo.repos.ProductRepository;
import com.example.demo.repos.RequestRepository;
import com.example.demo.sqldb.Product;
import com.example.demo.sqldb.Request;

@RestController
public class Producer {
	
	static final String directExchange = "direct-exchange";
	static final String directQueue = "direct-queue";
	
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
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private AmqpTemplate template;
	
	@GetMapping("/producer")
	public List<Request> getRequests(){
		return requestRepository.findAll();
	}
	
	@PostMapping("/producer")
	public Request createRequest(@Valid @RequestBody RequestPOJO requestPOJO) {
		template.convertAndSend(directExchange, "exchange.direct", requestPOJO);
		
		final Request req = new Request(requestPOJO.getOrderId());
	
		List<Product> list = new ArrayList<>();
		for(ProductPOJO p : requestPOJO.getProducts()) {
			list.add(new Product(p.getName(), p.getPrice()));
		}
		
		req.setProducts(list);
		
		return requestRepository.save(req);
		
	}

}
