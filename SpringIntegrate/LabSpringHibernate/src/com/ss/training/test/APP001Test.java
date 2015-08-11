package com.ss.training.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP001Dao;
import com.ss.training.entity.Person;

import junit.framework.TestCase;


public class APP001Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP001Test.class);

	public APP001Dao getDao() {
		return ((APP001Dao)this.applicationContext.getBean("APP001Dao"));
	}

	public void testHQL(){
		try{
		List<Person> result = getDao().findPerson();
		
		for(Person c:result){
			logger.info(c.getName()+" "+c.getLastname());
		}
		assertNotNull(result);
		}catch(NullPointerException ne){
				logger.info(ne.getMessage());
		}
		}
	
	public void testSQL(){
		List<Map<String,Object>> result = getDao().findPersonBySQL();
		try{
		for(Map<String,Object> c:result){
			logger.info(c.get("NAME")+" "+c.get("LASTNAME"));
		}
		assertNotNull(result);
		}catch(NullPointerException ne){
				logger.info(ne.getMessage());
		}
		}
	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
