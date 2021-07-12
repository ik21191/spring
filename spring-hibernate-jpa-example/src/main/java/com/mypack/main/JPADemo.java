package com.mypack.main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mypack.entity.PersonEntity;


public class JPADemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(301L);
		
		// get an object using primary key.
		PersonEntity person = entityManager.find(PersonEntity.class, personEntity.getId());
		System.out.println(person);
		
		System.out.println("Deleting Employee with ID = " + personEntity.getId());
		try {
			entityManager.remove(person);
		} catch(Exception e) {
			System.out.println(e);
		}
		entityManager.getTransaction().commit();
				
		System.out.println("Transaction committed.");

		// close the entity manager
		entityManager.close();
		entityManagerFactory.close();

	}
}
