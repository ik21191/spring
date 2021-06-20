package com.mypack.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mypack.beans.Person3;

public class Person3DaoImpl implements Person3Dao{

	private HibernateTemplate template;

   public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void save(Person3 p) {
		//template.setCheckWriteOperations(false);
		template.save(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person3> list() {
		List<Person3> personList = (List<Person3>)template.find("from Person3");
		return personList;
	}
  
}
