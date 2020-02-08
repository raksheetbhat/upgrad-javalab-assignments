
package com.example.demo.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RequestPOJO implements Serializable {

	private static final long serialVersionUID = -3930779617124479743L;
	
	@Setter
    @Getter
	private String orderId;
    
	@Setter
    @Getter
	private List<Product> products = null;
    
	@Setter
    @Getter
	private Recipient receipient;

}
