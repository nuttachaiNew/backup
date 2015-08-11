package com.ss.training.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ss.training.dao.APP002Dao;

public class APP002DaoImpl implements APP002Dao{

	// Define attribute Datasource and inject by Spring DI
	private DataSource dataSource ;
	private JdbcTemplate jdbcTemplate ; // use dataSource for new JdbcTemplate object
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
		
	}

	public List<Map<String, Object>> findPerson() {
		String sql = "SELECT  * FROM SET_PERSON";
		// Query For List
		return jdbcTemplate.queryForList(sql);
	}

}
