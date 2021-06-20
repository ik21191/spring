package com.mypack.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloWorldController 
{
	String message = "Test Example !";
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value="hobby", defaultValue="Default hobby")String[] list)  
	{
		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		System.out.println(list.length);
		System.out.println(list[0]);
		return mv;
	}

}
