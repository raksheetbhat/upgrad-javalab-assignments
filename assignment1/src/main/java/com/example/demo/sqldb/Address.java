
package com.example.demo.sqldb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Address implements Serializable {

    
	private static final long serialVersionUID = 579376556347145260L;
	
	
	private String addressType;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;

}
