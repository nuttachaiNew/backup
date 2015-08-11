package com.ss.training.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP003Dao;


public class APP003Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP003Test.class);
	
	public APP003Dao getDao() {
		return ((APP003Dao)this.applicationContext.getBean("APP003Dao"));
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
