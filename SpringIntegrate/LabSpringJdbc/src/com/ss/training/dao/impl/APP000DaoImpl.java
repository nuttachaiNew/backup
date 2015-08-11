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

import com.ss.training.dao.APP000Dao;

public class APP000DaoImpl implements APP000Dao {
	
	
	public List<Map<String,Object>> findPerson(){
		
		Connection connection =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection= DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1","SCOTT","TIGER");
			if(connection!=null){
				System.out.println("connect pass");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Connect JDBC by DriverManager
		// Driver : oracle.jdbc.driver.OracleDriver
		// URL : jdbc:oracle:thin:@172.16.0.32:1521:TWCMT1
		// USER : SCOTT
		// PASSWORD : TIGER
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "SELECT * FROM SET_PERSON";
		//Query and return it
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sql);
			
			 while(resultSet.next()){
				 Map<String,Object> maps = new HashMap<String,Object>();
			 maps.put("NAME", resultSet.getString("NAME"));
			 maps.put("LASTNAME", resultSet.getString("LASTNAME"));
	
			 list.add(maps);
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
