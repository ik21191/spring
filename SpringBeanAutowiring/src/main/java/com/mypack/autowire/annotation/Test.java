package com.mypack.autowire.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			Student student = (Student)ctx.getBean(Student.class);
			System.out.println(student.getAddress());
			System.out.println(student.getCourse());
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			ctx.close();
		}
		
	}
}
