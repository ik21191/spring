package com.journaldev.spring.jdbc.service;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;

public interface CustomerManager {

	public void createCustomer(Customer customer);
	public void createAddress(Address address);
	public void createCustomerAndAddress(Customer customer, Address address)throws Exception;
}
