package com.mypack.autowire.annotation;

import org.springframework.stereotype.Component;


//@Service ("courseService")
@Component
public class Course {

	String name;
	
	public Course() {
		System.out.println("Course() constructor is called.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
