package com.mypack.service;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	public TestServiceImpl() {
		System.out.println("TestServiceImpl() is called.");
	}

	@Override
	public void test() {
		System.out.println("this is service test");

	}

}
