package com.ss.training.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.ss.training.dao.APP001Dao;


public class APP001Test extends AbstractDependencyInjectionSpringContextTests {

	private static final Logger logger = Logger.getLogger(APP001Test.class);
	
	public APP001Dao getDao() {
		return ((APP001Dao)this.applicationContext.getBean("APP001Dao"));
	}

	public void testAction(){
		List<Map<String,Object>> result = getDao().findPerson();
		try{
		for(Map<String,Object> c:result){
			logger.info(c.get("NAME")+" "+c.get("LASTNAME"));
		}
		assertNotNull(result);
		}catch(NullPointerException ne){
			ne.printStackTrace();
		}
		}

	
	//@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"META-INF/springapp-context.xml"};
	}
}
