package com.mypack.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mypack.entity.CityEntity;
import com.mypack.entity.PersonEntity;
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
	   personEntity.setEmail(personModel.getEmail());
	   
	   CityEntity cityEntity = new CityEntity();
	   cityEntity.setCityName(personModel.getCity().getCityName());
	   personEntity.setCity(cityEntity);
      em.persist(personEntity);
   }

   @Override
   public List<PersonEntity> listPersons() {
      CriteriaQuery<PersonEntity> criteriaQuery = em.getCriteriaBuilder().createQuery(PersonEntity.class);
      @SuppressWarnings("unused")
      Root<PersonEntity> root = criteriaQuery.from(PersonEntity.class);
      return em.createQuery(criteriaQuery).getResultList();
   }

}
