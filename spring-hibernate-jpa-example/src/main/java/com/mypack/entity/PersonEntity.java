package com.mypack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
public class PersonEntity {

	@Id
	@SequenceGenerator(sequenceName = "CUSTOMER_ID_SEQ", initialValue = 1, allocationSize = 1, name = "CUSTOMER_ID_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_SEQ_GENERATOR")
	@Column(name = "PERSON_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	// Many to one mapping with City
	@ManyToOne(cascade = CascadeType.ALL)// CascadeType.ALL is required to insert into database
	@JoinColumn(name = "CITY_ID")
	private CityEntity city;

	public PersonEntity() {
		System.out.println("Object of PersonEntity created.");
	}

	public PersonEntity(String firstName, String lastName, String email, CityEntity city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

}
