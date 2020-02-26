package com.example.demo.nosqldb;

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
public class ProductCollection {
	
	@Id
	private long id;
	
	private String name;
    private int price;
	
    public ProductCollection(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
    
    

}
