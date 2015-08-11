package com.ss.training.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ss.training.dao.APP001Dao;
import com.ss.training.entity.Person;

public class APP001DaoImpl implements APP001Dao {
	




	private static final Logger logger = Logger.getLogger(APP001DaoImpl.class);

	// Define attribute SessionFactory and inject by Spring DI
	private SessionFactory sessionFactory ;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	public List<Person> findPerson(){
		List<Person> list = null;
		String hql = "FROM Person";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		list=query.list();
		session.close();
		return list;
	}
	
	
	public List<Map<String,Object>> findPersonBySQL(){
		List<Map<String, Object>> listperson = null;
		String sql = "SELECT * FROM SET_PERSON";
		Session session = sessionFactory.openSession();	
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		listperson=query.list();
		
		return listperson;
	}

}
