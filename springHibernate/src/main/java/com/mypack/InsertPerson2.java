package com.mypack;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypack.beans.Person2;
import com.mypack.dao.Person2Dao;

public class InsertPerson2 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4-SessionFactory.xml");
		
		Person2Dao person2DAO = (Person2Dao)context.getBean("person2DAO");
		
		Person2 person = new Person2();
		person.setName("Vinay Kumar"); 
		person.setCountry("India");
		
		person2DAO.save(person);
		
		//System.out.println("Person::" + person);
		
		List<Person2> list = person2DAO.list();
		
		for(Person2 p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		context.close();	
	}
}
