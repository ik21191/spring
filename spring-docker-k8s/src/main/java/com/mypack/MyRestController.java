package com.mypack;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	private static final Logger log = LoggerFactory.getLogger(MyRestController.class);
	
	private Environment env;
	public MyRestController(Environment env) {
		this.env = env;
		log.info("############# Object of MyRestController is created.##############");
	}
	
	@GetMapping("/")
	public String home() {
	  	log.info("####### Home page loaded. #######");
	  	String returnValue =  "<b>Deployed Platform: </b>" + env.getProperty("deployed.platform")  
	  		+	"<br/><br/><b>Application is running.</b> <br/><br/><b>Current time is : </b>" + new Date();
	  	return returnValue;
	}

	/**
	 * Sample html code to send user data
	<form action="http://localhost:8080/api/details/" method="post">
  		<input type="text" id="name" name="name">
  		<input type="submit" value="Submit">
	</form>
	 */
	@PostMapping("/api/details")
	public String convertToUpper(@RequestParam String name) {
		log.info("####### Converting name to uppercase. #######");
		if (name == null || name.trim().length() == 0) {
			log.error("####### name is required. #######");
			return "name is required";
		}
		return name.toUpperCase();
	}
}
