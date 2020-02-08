
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
public class Address implements Serializable {

    
	private static final long serialVersionUID = 579376556347145260L;
	
	@Setter
    @Getter
	private String addressType;
	
	@Setter
    @Getter
    private String line1;
	
	@Setter
    @Getter
    private String line2;
	
	@Setter
    @Getter
    private String city;
	
	@Setter
    @Getter
    private String state;
	
	@Setter
    @Getter
    private String country;

}
