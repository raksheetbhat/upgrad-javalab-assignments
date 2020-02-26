package com.example.demo.sqldb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
@Entity
@Table(name = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = -3930779617124479743L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="orderid")
	private String orderId;
    
	@OneToMany(mappedBy = "requestObj", cascade = CascadeType.ALL)
	private List<Product> products;

	public Request(String orderId) {
		super();
		this.orderId = orderId;
	}
	
	public void setProducts(List<Product> products) {
		for(Product product : products) {
			product.setRequestObj(this);
		}
		
		this.products = products;
	}
    
//	private Recipient recipient;

}
