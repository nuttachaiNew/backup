package com.ss.training.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ss.training.dao.APP002Dao;
import com.ss.training.entity.Person;

public class APP002DaoImpl implements APP002Dao {

	private HibernateTemplate hibernateTemplate;// use SessionFactory for new HibernateTemplate object
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	

	public void setSessionFactory(SessionFactory sessionFactory) {
		//do some thing
		this.hibernateTemplate= new HibernateTemplate(sessionFactory);
	}
	
	public List<Person> findPerson() {
		String hql = "FROM Person";
		// Use hibernateTemplate for find object for return result
		return getHibernateTemplate().find(hql);
	}
	
	public List<Person> findPersonByCtiteria(Map<String, Object> criteriaMap) {
		// Create DetachedCriteria and query Person
		// add Restriction like of the "code" from criteriaMap.get("code")
		// Use hibernateTemplate for find object by DetachedCriteria
		DetachedCriteria criteria =  DetachedCriteria.forClass(Person.class);
	
		if(criteriaMap!=null && criteriaMap.isEmpty()){
			for(String c:criteriaMap.keySet()){
				if(criteriaMap.get(c)!=null){
					criteria.add(Restrictions.like(c, criteriaMap.get(c)));
				}
			}
			
		}
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
