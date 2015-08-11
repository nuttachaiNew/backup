package com.ss.training.dao;

import java.util.List;
import java.util.Map;

import com.ss.training.entity.Person;

public interface APP002Dao {

	public List<Person> findPerson();
	public List<Person> findPersonByCtiteria(Map<String, Object> criteriaMap);
}
