
package com.example.demo.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RecipientPOJO implements Serializable {

	private static final long serialVersionUID = -6332415425170863718L;
	
	private BasicProfilePOJO basicProfile;
    private List<AddressPOJO> addresses = null;

}
