package com.mypack.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("imran")
				&& password.equalsIgnoreCase("123456");
	}

}
