package com.mypack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mypack.beans.Person2;

public class Person2DaoImpl implements Person2Dao{

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
	public void save(Person2 p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person2> list() {
		Session session = this.sessionFactory.openSession();
		List<Person2> personList = session.createQuery("from Person2").list();
		session.close();
		return personList;
	}
  
}
