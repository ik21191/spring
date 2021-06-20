package com.mypack.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mypack.beans.Person3;

public class Person3DaoImplWithHibernateDaoSupport extends HibernateDaoSupport implements Person3Dao {

	@Override
	public void save(Person3 p) {
		getHibernateTemplate().save(p);
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Person3> list() {
		*//**List<Person3> personList = (List<Person3>)getHibernateTemplate().find("from Person3");*//*
		return getHibernateTemplate().execute(new HibernateCallback<List<Person3>>() {
			@Override
			public List<Person3> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Person3");
				return query.list();
			}
		});
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person3> list() {
		//List<Person3> personList = (List<Person3>)getHibernateTemplate().find("from Person3");
		return getHibernateTemplate().execute(new HibernateCallback<List<Person3>>() {
			@Override
			public List<Person3> doInHibernate(Session session) throws HibernateException, SQLException {
				 //Criteria criteria = session.createCriteria(Student1.class).add(Restrictions.eq("studentId", 101));
		         Criteria criteria = session.createCriteria(Person3.class).
		         add(Restrictions.like("name", "%%"));
		         return criteria.list();
			}
		});
	}
  
}
