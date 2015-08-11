package com.ss.training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import com.ss.training.dao.APP001Dao;

public class APP001DaoImpl implements APP001Dao {

	
	
	// Define attribute Datasource and inject by Spring DI
   
	//Connection conn = ds.getConnection();
		// Connect JDBC by DataSource
		// Driver : oracle.jdbc.driver.OracleDriver
		// URL : jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1
		// USER : SCOTT
		// PASSWORD : TIGER
	
	Connection connection =null;
	private DataSource dataSource ;
	ResultSet resultSet=null;
	
	
	public List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public List<Map<String,Object>> findPerson(){
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "SELECT  * FROM SET_PERSON";
		try {
			Statement statement = connection.createStatement();
			 resultSet =statement.executeQuery(sql);
			
			 while(resultSet.next()){
				 Map<String,Object> maps = new HashMap<String,Object>();
			 maps.put("NAME", resultSet.getString("NAME"));
			 maps.put("LASTNAME", resultSet.getString("LASTNAME"));
	
			 list.add(maps);
			 statement.close();
			 connection.close();

			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list;
}
}
