package com.mypack.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mypack.entity.CityEntity;
import com.mypack.entity.PersonEntity;
import com.mypack.entity.PersonIdentity;
import com.mypack.model.CityModel;
import com.mypack.model.PersonIdentityModel;
import com.mypack.model.PersonModel;

/**
 * @author imssbora
 *
 */
@Repository
public class PersonDaoImp implements PersonDao {

   @PersistenceContext(unitName = "LOCAL_PERSISTENCE")
   private EntityManager em;

   @Override
   public void add(PersonModel personModel) {
	   PersonEntity personEntity = new PersonEntity();
	   personEntity.setFirstName(personModel.getFirstName());
	   personEntity.setLastName(personModel.getLastName());
	   personEntity.setEmail(personModel.getEmail());
	   
	   CityEntity cityEntity = new CityEntity();
	   cityEntity.setCityName(personModel.getCity().getCityName());
	   personEntity.setCity(cityEntity);
	   
	   List<PersonIdentity> personIdentityList = new ArrayList<>();
	   if(personModel.getPersonIdentityModelList() != null) {
		   for(PersonIdentityModel personIdentityModel : personModel.getPersonIdentityModelList()) {
			   PersonIdentity personIdentity = new PersonIdentity(personIdentityModel.getPersonIdentityName());
			   personIdentity.setPersonEntity(personEntity);
			   personIdentityList.add(personIdentity);
		   }
	   }
	   personEntity.setPersonIdentityList(personIdentityList);
      em.persist(personEntity);
   }

   @Override
   public List<PersonEntity> listPersons() {
      CriteriaQuery<PersonEntity> criteriaQuery = em.getCriteriaBuilder().createQuery(PersonEntity.class);
      @SuppressWarnings("unused")
      Root<PersonEntity> root = criteriaQuery.from(PersonEntity.class);
      return em.createQuery(criteriaQuery).getResultList();
   }
   
   @Override
	public PersonModel findPerson(long id) {
	   PersonEntity personEntity = em.find(PersonEntity.class, id);
	   PersonModel personModel = null;
	   CityModel cityModel = null;
	   if(personEntity != null) {
		   personModel = new PersonModel(); 
		   personModel.setFirstName(personEntity.getFirstName());
		   personModel.setLastName(personEntity.getLastName());
		   personModel.setEmail(personEntity.getEmail());
		   
		   CityEntity cityEntity = personEntity.getCity();
		   
		   if(cityEntity != null) {
			   cityModel = new CityModel();
			   cityModel.setCityName(cityEntity.getCityName());
			   personModel.setCity(cityModel);
		   }
		   List<PersonIdentityModel> personIdentityModelList = new ArrayList<>();
		   if(personEntity.getPersonIdentityList() != null) {
			   for(PersonIdentity personIdentity: personEntity.getPersonIdentityList()) {
				   personIdentityModelList.add(new PersonIdentityModel(personIdentity.getPersonIdentityName()));
			   }
		   }
		   personModel.setPersonIdentityModelList(personIdentityModelList);
	   }
	   return personModel;
	}

}
