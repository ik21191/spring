package com.mypack.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/addcontact1")
public class AddContactRedirectController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String myMethod()
	{
		System.out.println("AddContactController");
		return "redirect:contacts.htm";
	}
}
