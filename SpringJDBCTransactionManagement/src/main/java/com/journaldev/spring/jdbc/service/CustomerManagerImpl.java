package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.CustomerDAO;
import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.createCustomer(cust);
	}
	
	@Override
	@Transactional
	public void createAddress(Address address) {
		customerDAO.createAddress(address);
	}
	
	@Override
	@Transactional
	public void createCustomerAndAddress(Customer customer, Address address) {
		createCustomer(customer);
		createAddress(address);
	}
}
