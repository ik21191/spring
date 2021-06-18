package com.mypack.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_DETAILS")
public class EmpDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAIL_ID")
	private int id;
	
	@Column(name = "CITY", nullable = false, unique = true)
	private String city;
	
	@Column(name = "PINCODE", nullable = false, unique = true)
	private String pincode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + ", CITY: " + city + ", PINCODE: " + pincode;
	}
}
