package com.ss.training.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP002Dao;


public class APP002Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP002Test.class);
	
	public APP002Dao getDao() {
		return ((APP002Dao)this.applicationContext.getBean("APP002Dao"));
	}

	public void testAction(){
		List<Map<String,Object>> result = getDao().findPerson();
		for(Map<String,Object> c:result){
			logger.info(c.get("NAME")+" "+c.get("LASTNAME"));
		}
		assertNotNull(result);
	}
	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
