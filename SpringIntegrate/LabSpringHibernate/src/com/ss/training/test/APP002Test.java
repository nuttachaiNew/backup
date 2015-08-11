package com.ss.training.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP002Dao;
import com.ss.training.entity.Person;


public class APP002Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP002Test.class);
	
	public APP002Dao getDao() {
		return ((APP002Dao)this.applicationContext.getBean("APP002Dao"));
	}

	public void testFindPerson(){

		List<Person> result = getDao().findPerson();
		try{
		for(Person c:result){
			logger.info(c.getName()+" "+c.getLastname());
		}
		assertNotNull(result);
	}catch(NullPointerException ne){}
	}
	
	public void testFindPersonByCtiteria(){
		Map<String, Object> criteriaMap = new HashMap<String, Object>();
		criteriaMap.put("code", "5701007");
		List<Person> result = getDao().findPersonByCtiteria(criteriaMap);
		try{
		for(Person c:result){
			logger.info(c.getName()+" "+c.getLastname());
		}
		assertNotNull(result);
		}catch(NullPointerException ne){}
		}
	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
