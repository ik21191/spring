package com.mypack;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypack.beans.Person3;
import com.mypack.dao.Person3Dao;

public class InsertPerson3 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4-HibernateTemplate.xml");
		
		Person3Dao person3 = (Person3Dao)context.getBean("person3");
		
		Person3 person = new Person3();
		person.setName("Imran Khan"); 
		person.setCountry("India");
		System.out.println("Saving...........");
		person3.save(person);
		System.out.println("Saved.\nSaved details are given below: ");
		
		List<Person3> list = person3.list();
		for(Person3 p : list){
			System.out.println("Person List::" + p);
		}
		context.close();	
	}
}
