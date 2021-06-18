package com.mypack.main;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mypack.app.config.AppConfig;
import com.mypack.entity.CityEntity;
import com.mypack.entity.PersonEntity;
import com.mypack.model.CityModel;
import com.mypack.model.PersonModel;
import com.mypack.service.PersonService;

/**
 * @author imssbora
 *
 */
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      PersonService personService = context.getBean(PersonService.class);

      // Add Persons
      CityModel city = new CityModel("New Delhi");
      personService.add(new PersonModel("Imran", "Khan", "imran.khan@gmail.com", city));
      personService.add(new PersonModel("Rahul", "Kumar", "rahul.kumar@gmail.com", city));
      
      // Get Persons
      List<PersonEntity> persons = personService.listPersons();
      for (PersonEntity person : persons) {
         System.out.println("Id = "+person.getId());
         System.out.println("First Name = "+person.getFirstName());
         System.out.println("Last Name = "+person.getLastName());
         System.out.println("Email = "+person.getEmail());
         System.out.println();
      }

      context.close();
   }
}
