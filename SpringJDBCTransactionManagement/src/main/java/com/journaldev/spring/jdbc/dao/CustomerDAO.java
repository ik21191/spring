package com.journaldev.spring.jdbc.dao;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;

public interface CustomerDAO {

	public void createCustomer(Customer customer);
	public void createAddress(Address address);
}