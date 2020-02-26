
package com.example.demo.sqldb;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BasicProfile implements Serializable {

	private static final long serialVersionUID = -4375482981051480572L;
	
	
	private String name;
    private String phoneNumber;
    private String email;

}
