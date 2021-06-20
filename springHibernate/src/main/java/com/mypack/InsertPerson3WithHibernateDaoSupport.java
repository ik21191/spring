package com.mypack;


import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mypack.beans.Person3;
import com.mypack.dao.Person3Dao;

public class InsertPerson3WithHibernateDaoSupport {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring3-hibernateDaoSupport.xml");
		
		Person3Dao person3 = (Person3Dao)context.getBean("person3");
		
		Person3 person = new Person3();
		person.setName("Vijay Kr"); 
		person.setCountry("UK");
		System.out.println("Saving...........");
		person3.save(person);
		System.out.println("Saved.\nSaved details are given below: ");
		/**Below method also explains the use of HibernateCallBack interface*/
		List<Person3> list = person3.list();
		for(Person3 p : list){
			System.out.println("Person List::" + p);
		}
		context.close();	
	}
}
