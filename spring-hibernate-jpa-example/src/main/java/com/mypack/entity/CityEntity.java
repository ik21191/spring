package com.mypack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class CityEntity {

	@Id
	@SequenceGenerator(sequenceName = "CITY_ID_SEQ", initialValue = 1, allocationSize = 1, name = "CITY_ID_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_ID_SEQ_GENERATOR")
	
	
	@Column(name = "CITY_ID")
	private Long id;
	
	@Column(name = "CITY_NAME")
	private String cityName;

	
	public CityEntity() {
		System.out.println("Object of CityEntity created.");
	}

	public CityEntity(String cityName) {
		this.cityName = cityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
