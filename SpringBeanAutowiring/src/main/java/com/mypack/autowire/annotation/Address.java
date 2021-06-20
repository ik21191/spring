package com.mypack.autowire.annotation;

import org.springframework.stereotype.Component;

//@Service ("addressService")
@Component
public class Address {

	String id;
	String city;
	
	public Address() {
		System.out.println("Default : Address() constructor is called");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
