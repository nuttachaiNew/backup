package com.ss.training.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ss.training.dao.APP003Dao;
import com.ss.training.entity.Person;

public class APP003DaoImpl extends HibernateDaoSupport implements APP003Dao {

	// Don't define HibernateTemplate in class
	
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
