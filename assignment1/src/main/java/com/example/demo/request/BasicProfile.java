
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
public class BasicProfile implements Serializable {

	private static final long serialVersionUID = -4375482981051480572L;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
    private String phoneNumber;
	
	@Getter
	@Setter
    private String email;

}
