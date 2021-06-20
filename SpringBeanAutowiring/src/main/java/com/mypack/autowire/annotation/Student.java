package com.mypack.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**We can't use @Autowire annotation on overloaded constructor, we can use @Autowire on setter methods for this case*/

//@Service ("studentService")
@Component
public class Student {

	//@Autowired //Autowire on field
	private Address address;
	private Course course;

	//@Autowired // Autowire on constructor
	public Student(Address address) {
		this.address = address;
	}
	
	public Student() {
		System.out.println("Student() constructor is called.");
	}
	
	public Address getAddress() {
		return address;
	}

	@Autowired
	public void setAddress(Address address) {
		this.address = address;
		System.out.println("setAddress(Address address) called...");
	}

	public Course getCourse() {
		return course;
	}

	@Autowired//If we comment this line then this setter method will not called.
	public void setCourse(Course course) {
		this.course = course;
		System.out.println("setCourse(Course course) is called...");
	}
	
}
