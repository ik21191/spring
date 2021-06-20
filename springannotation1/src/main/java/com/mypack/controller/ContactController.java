package com.mypack.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mypack.service.TestService;
 
@Controller
@SessionAttributes
public class ContactController {
 @Autowired
 TestService testService;
 
    @RequestMapping(value = "/addcontact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contacttt") Contact contact, BindingResult result) {
         
        System.out.println("First Name:" + contact.getFirstname() + 
                    "\tLast Name:" + contact.getLastname());
        System.out.println("testService object reference name : " + testService);
         testService.display();
        //return "redirect:contacts.htm";
        return "aaa";
    }
     
    @RequestMapping("/contacts")
    public ModelAndView showContacts() {
         
        return new ModelAndView("contact", "command", new Contact("Imran","Khan","abc@abc.com","1234567890"));
        //contact represents view
    }
}