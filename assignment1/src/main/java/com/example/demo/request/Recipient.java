
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
public class Recipient implements Serializable {

	private static final long serialVersionUID = -6332415425170863718L;
	
	@Getter
	@Setter
	private BasicProfile basicProfile;
	
	@Getter
	@Setter
    private List<Address> addresses = null;

}
