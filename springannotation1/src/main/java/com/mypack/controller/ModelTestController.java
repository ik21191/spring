package com.mypack.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypack.pojo.Student;

@Controller
@RequestMapping("/hello1")
public class ModelTestController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String myMethod(ModelMap model)
	{
		System.out.println("ModelTestController");
		model.put("myName", "Imran Khan");
		Student s=new Student();
		s.setRoll(201);
		s.setName("Vinay Kumar");
		model.put("student", s);
		return "result";
	}
}
