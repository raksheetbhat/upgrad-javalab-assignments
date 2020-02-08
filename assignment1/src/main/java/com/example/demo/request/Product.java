
package com.example.demo.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Product implements Serializable {

	private static final long serialVersionUID = 490038513927066972L;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
    private Integer price;

}
