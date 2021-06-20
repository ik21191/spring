package com.mypack.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

	public TestDaoImpl() {
		System.out.println("TestDaoImpl() constructor is called.");
	}
	public void display() {
		System.out.println("Hello this is display() of TestDao");

	}

}
