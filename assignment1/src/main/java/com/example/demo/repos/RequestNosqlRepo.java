package com.example.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.nosqldb.RequestCollection;

public interface RequestNosqlRepo extends MongoRepository<RequestCollection, Long> {
	
	public RequestCollection findByOrderId(String orderId);

}
