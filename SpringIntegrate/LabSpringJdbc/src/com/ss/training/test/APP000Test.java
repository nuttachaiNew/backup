package com.ss.training.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP000Dao;


public class APP000Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP000Test.class);
	
	public APP000Dao getDao() {
		return ((APP000Dao)this.applicationContext.getBean("APP000Dao"));
	}

	public void testAction(){
	try{
		List<Map<String,Object>> result = getDao().findPerson();
		for(Map<String,Object> c:result){
			logger.info(c.get("NAME")+" "+c.get("LASTNAME"));
		}
		assertNotNull(result);
	}catch(NullPointerException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}
	}
	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
