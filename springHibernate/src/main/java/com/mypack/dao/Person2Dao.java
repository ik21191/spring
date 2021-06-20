package com.mypack.dao;

import java.util.List;

import com.mypack.beans.Person2;

public interface Person2Dao {

	public void save(Person2 p);
	public List<Person2> list();
}
