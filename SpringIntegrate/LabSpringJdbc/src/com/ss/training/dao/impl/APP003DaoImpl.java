package com.ss.training.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ss.training.dao.APP003Dao;

public class APP003DaoImpl extends JdbcDaoSupport implements APP003Dao {

	// Don't define JdbcTemplate in class
	
	public List<Map<String, Object>> findPerson() {
		String sql = "SELECT  * FROM SET_PERSON";
		// Query For List
		return getJdbcTemplate().queryForList(sql);
	}

}
