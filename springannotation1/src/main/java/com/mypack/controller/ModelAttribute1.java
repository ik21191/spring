package com.mypack.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypack.pojo.Emp;
import com.mypack.pojo.Student;
@Controller
@RequestMapping("/model1")
public class ModelAttribute1 
{
	@RequestMapping(method=RequestMethod.GET)
	public String myMethod(@ModelAttribute("e") Emp emp,@ModelAttribute("st") Student stn )
	{
		System.out.println("ModelAttribute1");
		emp.setName("ABC");
		System.out.println(emp.getName());
		stn.setRoll(101);
		stn.setName("Imran Khan");
		return "result1";
	}
}
