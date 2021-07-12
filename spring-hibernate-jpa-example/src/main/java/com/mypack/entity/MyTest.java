package com.mypack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MY_TEST")
public class MyTest {

	/**This entity is not used for persisting into the database, it is only used to explain use of PersistenceContext*/
	@Id
	@SequenceGenerator(sequenceName = "CUSTOMER_ID_SEQ", initialValue = 1, allocationSize = 1, name = "CUSTOMER_ID_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_SEQ_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	
	public MyTest() {
		System.out.println("Object of MyTest created.");
	}

	public MyTest(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
