package com.mypack.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRIVILEGE")
public class Privilege {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRIVILEGE_ID")
	private long id;
	
	@Column(name="PRIVILEGE_NAME")
	private String previlegeName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrevilegeName() {
		return previlegeName;
	}
	public void setPrevilegeName(String previlegeName) {
		this.previlegeName = previlegeName;
	}
}
