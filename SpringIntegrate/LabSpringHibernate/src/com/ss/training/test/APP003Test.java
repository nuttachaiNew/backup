package com.ss.training.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP002Dao;
import com.ss.training.dao.APP003Dao;
import com.ss.training.entity.Person;


public class APP003Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP003Test.class);
	
	public APP003Dao getDao() {
		return ((APP003Dao)this.applicationContext.getBean("APP003Dao"));
	}

	public void testFindPerson(){
		List<Person> result = getDao().findPerson();
		for(Person c:result){
			logger.info(c.getName()+" "+c.getLastname());
		}
		assertNotNull(result);
	}
	
	public void testFindPersonByCtiteria(){
		Map<String, Object> criteriaMap = new HashMap<String, Object>();
		criteriaMap.put("code", "5701007");
		List<Person> result = getDao().findPersonByCtiteria(criteriaMap);
		for(Person c:result){
			logger.info(c.getName()+" "+c.getLastname());
		}
		assertNotNull(result);
	}

	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
