package com.mypack.test.app;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.mypack.service.EmployeeService;

public class Start {
	private static Logger log = Logger.getLogger(Start.class);
	
	public static void main(String[] args) {
    	ApplicationContext context = null;
    	try {
    		context = new ClassPathXmlApplicationContext("applicationContext.xml");
    		EmployeeService employeeService = context.getBean(EmployeeService.class);
            employeeService.execute();
    	} catch(DataAccessException e) {
    		log.error(e);
    	} catch(Exception e) {
    		log.error(e);
    	}
    }
  
}
