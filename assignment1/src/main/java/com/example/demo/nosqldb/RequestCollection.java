package com.example.demo.nosqldb;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCollection {
	@Id
	private long id;
	
	private String orderId;
    
	private List<ProductCollection> products;

	public RequestCollection(String orderId, List<ProductCollection> products) {
		super();
		this.orderId = orderId;
		this.products = products;
	}
	
	
}
