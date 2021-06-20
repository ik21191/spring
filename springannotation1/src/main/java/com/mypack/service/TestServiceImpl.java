package com.mypack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypack.dao.TestDao;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestDao testDao;
	
	public TestServiceImpl() {
		System.out.println("TestServiceImpl() constructor is called.");
	}
	public void display() {
		testDao.display();
	}

}
