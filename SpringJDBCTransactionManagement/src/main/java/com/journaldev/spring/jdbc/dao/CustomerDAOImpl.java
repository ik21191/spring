package com.journaldev.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.journaldev.spring.jdbc.model.Address;
import com.journaldev.spring.jdbc.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createCustomer(Customer customer) {

		String queryCustomer = "insert into Customer (id, name) values (?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(), customer.getName() });
		System.out.println("Inserted into Customer Table Successfully");
	}
	
	@Override
	public void createAddress(Address address) {

		String queryAddress = "insert into Address1 (id, address,country) values (?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryAddress, new Object[] { address.getId(), address.getAddress(), address.getCountry() });
		System.out.println("Inserted into Address Table Successfully");
	}
}
