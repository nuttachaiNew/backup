package com.ss.training.dao;

import java.util.List;
import java.util.Map;

import com.ss.training.entity.Person;

public interface APP001Dao {

	public List<Person> findPerson();
	public List<Map<String,Object>> findPersonBySQL();
}
