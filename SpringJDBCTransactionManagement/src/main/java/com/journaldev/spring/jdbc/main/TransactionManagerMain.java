package com.journaldev.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;
import com.journaldev.spring.jdbc.service.CustomerManager;
import com.journaldev.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager", CustomerManagerImpl.class);

		Customer customer = createDummyCustomer();
		Address address = createDummyAddress();
		customerManager.createCustomerAndAddress(customer, address);
		ctx.close();
	}

	private static Customer createDummyCustomer() {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Imran Khan");
		return customer;
		
	}
	
	private static Address createDummyAddress() {
		Address address = new Address();
		address.setId(1);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr, San Jose, CA 95129");
		return address;
	}
}
