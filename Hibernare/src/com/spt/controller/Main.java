package com.spt.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spt.domain.Country;
import com.spt.domain.Departments;
import com.spt.domain.Employees;
import com.spt.domain.Job_History;
import com.spt.domain.Jobs;
import com.spt.domain.Location;
import com.spt.domain.Regeion;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Integer regionID=0;
		String regionName="";
		Logger logger = LoggerFactory.getLogger(Main.class);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	
		java.util.Date dNow = new java.util.Date();
		java.util.Date dlast = new java.util.Date();
		
		//String date = new SimpleDateFormat("dd-MM-yyyy").format(dNow); 
		session.beginTransaction();
	
		
		/*region country location jobs employee 
		  Regeion reg = new Regeion();
		reg.setRegionId(48);
		reg.setRegionName("test_insert");
		session.saveOrUpdate(reg);
		Object identifier = session.getIdentifier(reg);
		session.getTransaction().commit();
		
		Country country = new Country();
		country.setCountryID("NW");
		country.setCountryName("Nuttachai");
		country.setRegionID(1);
		session.saveOrUpdate(country);
		session.getTransaction().commit();
		
		Location location = new Location();
		location.setLocationID(3000);
		location.setStreetAddress("39-415 white strest");
		location.setPostalCode("11500");
		location.setCity("Thanyaburi");
		location.setStateProvince("Pathumthani");
		location.setCountryID("NW");
		session.saveOrUpdate(location);
		session.getTransaction().commit();
		
		
		Jobs jobs = new Jobs();
		jobs.setJobID("FB");
		jobs.setJobTitle("Facebook");
		jobs.setMinSalary(5000);
		jobs.setMaxSalary(5100);
		session.saveOrUpdate(jobs);
		session.getTransaction().commit();
		
		
		
		
		
		Job_History jobHis = new Job_History();
		jobHis.setEmployeeID(1);
		jobHis.setStartDate(dNow);
		jobHis.setEndDate(dNow);
		jobHis.setJobID("FB");
		jobHis.setDepartmentID(null);
		session.saveOrUpdate(jobHis);
		session.getTransaction().commit();
		
		
		Departments dep = new Departments();
		dep.setDepartmentID(69);
		dep.setDepartmentName("Relexszz");
		dep.setLocationID(3000);
		dep.setManagerID(null);
		session.saveOrUpdate(dep);
	
		session.getTransaction().commit();
	
		
		Employees emp = new Employees();
		emp.setEmployeeID(700);
		emp.setFirstName("New");
		emp.setLastName("Nuttachai");
		emp.setEmail("newss@mail.com");
		emp.setPhoneNumber("08999999");
		emp.setHireDate(null);
		emp.setJobID("FB");
		emp.setSalary(5800);
		emp.setCommissionPCT(null);
		emp.setHireDate(dNow);
		emp.setDepartmentID(90);
		session.saveOrUpdate(emp);
		session.getTransaction().commit();
	
	Job_History jobHis = new Job_History();
		jobHis.setEmployeeID(700);
		jobHis.setStartDate(dNow);
		jobHis.setEndDate(dNow);
		jobHis.setJobID("FB");
		jobHis.setDepartmentID(null);
		session.saveOrUpdate(jobHis);
		session.getTransaction().commit();
		
		Regeion reg = (Regeion) session.get(Regeion.class,1);
		Regeion reg = new Regeion();
		reg.setRegionId(1);
		reg.setRegionName("update1");
		session.update(reg);
		session.getTransaction().commit();
		
		Regeion reg = new Regeion();
		reg.setRegionId(48);
		session.delete(reg);
		session.getTransaction().commit();
		
		
		Set<Country> setCountry = new HashSet<Country>();
		Regeion reg = new Regeion();

		Country country1 = new Country();
		Country country2 = new Country();
		Country country3 = new Country();
		
		reg.setRegionId(31);
		reg.setRegionName("AMD");
		
		country1.setCountryID("LA");
		country1.setCountryName("LAOS");
		country1.setReg(reg);
		setCountry.add(country1);
		
		country2.setCountryID("MM");
		country2.setCountryName("พม่า");
		country2.setReg(reg);
		setCountry.add(country2);
		
		country3.setCountryID("ML");
		country3.setCountryName("มาเลเซีย");
		country3.setReg(reg);
		setCountry.add(country3);		
		
		reg.setCountries(setCountry);
		session.saveOrUpdate(reg);
		session.getTransaction().commit();

		
		
		Regeion reg = (Regeion) session.get(Regeion.class,1);
		reg.getCountries();
		for(Country C:reg.getCountries()){
			System.out.println(reg.getRegionName());
		}
	

		Country country=(Country) session.get(Country.class, 1){
			country.getLocation();
			for(Location l: country.getLocation()){
				System.out.println(country.getCountryID());
				
			}
		}
		Regeion reg = (Regeion) session.get(Regeion.class,1);
		reg.getCountries();
		for(Country C:reg.getCountries()){
			for(Location l:C.getLocation()){
				System.out.println(C.getCountryName());
			}
			System.out.println(reg.getRegionName());
		Regeion reg = (Regeion) session.get(Regeion.class,1);

			
		Regeion reg = new Regeion();
		reg.setRegionId(1);
		reg.setRegionName("update1");
		session.update(reg);
		session.getTransaction().commit();

		}

				Regeion reg = new Regeion();
		reg.setRegionId(48);
		session.delete(reg);
		session.getTransaction().commit();
		---
		
		
		Regeion reg = (Regeion) session.get(Regeion.class,1);
		reg.getCountries();
		for(Country C:reg.getCountries()){
			for(Location l:C.getLocation()){
				for(Departments d:l.getDepartment()){
					for(Employees e:d.getEmployees()){
						System.out.println(e.getEmail());
					}
				}
			}
		}
	
		
		Set<Country> setCountry = new HashSet<Country>();
		Regeion reg = new Regeion();

		Country country1 = new Country();
		Country country2 = new Country();
		Country country3 = new Country();
		
		reg.setRegionId(82);
		reg.setRegionName("AMD");
		
		country1.setCountryID("LA");
		country1.setCountryName("LAOS");
		country1.setReg(reg);
		setCountry.add(country1);
		
		country2.setCountryID("MM");
		country2.setCountryName("พม่า");
		country2.setReg(reg);
		setCountry.add(country2);
		
		country3.setCountryID("ZZ");
		country3.setCountryName("มาเลเซีย");
		country3.setReg(reg);
		setCountry.add(country3);		
		
		reg.setCountries(setCountry);

		session.merge(reg);
		session.getTransaction().commit();

		session.close();
	
	
			Regeion reg = (Regeion) session.get(Regeion.class,1);
			reg.getCountries();
			for(Country C:reg.getCountries()){
				for(Location l:C.getLocation()){
					System.out.println(C.getCountryName());
				}
		
	criteria select *
	
		 Criteria crit = session.createCriteria(Location.class);
		 List<Location> results = crit.list();
		
		 for(Location l:results){
			 	System.out.println(l.getLocationID());
				
			}
		
		
		
		
		//crit.add(Restrictions.eq("regionID", 5));
		//crit.add(Restrictions.gt("regionId",2));
		//crit.add(Restrictions.lt("regionId",5));
		//crit.setFirstResult(0);
		//crit.setMaxResults(3);
		 
		
		//crit.setProjection(Projections.rowCount());
		//ProjectionList projectList = Projections.projectionList();
		//crit.setProjection(Projections.property("regionName"));
	//set projection
	
		ProjectionList projectList = Projections.projectionList();
		projectList.add(Projections.property("regionName"));
		projectList.add(Projections.property("regionId"));
		crit.setProjection( projectList );
		
	 crit.setResultTransformer(Transformers.aliasToBean(Map.class));
		List results = crit.list();
		System.out.println(results);
		
		เพิ่ม parameter
		String hql = "FROM Regeion R WHERE R.regionName like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name","A%");
		List<Regeion> results = query.list();
			System.out.print("Regions : "+results);
		
	String hql = "INSERT INTO Regeion(regionName, regionId)"  + 
	             "SELECT firstName, lastName, salary FROM old_employee";
	Query query = session.createQuery(hql);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);	
		
			
			
			String hql = "DELETE FROM Employee "  + 
	             "WHERE id = :employee_id";
	Query query = session.createQuery(hql);
	query.setParameter("employee_id", 10);
	int result = query.executeUpdate();
	System.out.println("Rows affected: " + result);
	
	criteria
		
		Criteria crit = session.createCriteria(Regeion.class);
		Criterion nameRestriction = Restrictions.like("regionName", "A%");
		crit.add( nameRestriction );
		List<Regeion> results = crit.list();
		for(Regeion r:results){
			logger.info("{}"+r.getRegionName()+""+r.getRegionId());
		}
	
			Criteria crit = session.createCriteria(Regeion.class);
		ProjectionList projectList = Projections.projectionList();
		projectList.add(Projections.rowCount());
		crit.setProjection( projectList );
		List results = crit.list();
		logger.info("{}",results);
	
		DetachedCriteria query = DetachedCriteria.forClass(Regeion.class);
		List<Regeion> results =   query.getExecutableCriteria(session).list();
			for(Regeion r:results){
				logger.info("{}",r.getRegionName());
			}
		
		
			String hql = "FROM Regeion R WHERE R.regionName = :name";
				Query query = session.createQuery(hql);
				query.setParameter("name","Americas");
				List<Regeion> results = query.list();
				for(Regeion r:results){
					logger.info("{}",r.getRegionId());
		
				}
		
		Query query =	session.createQuery("update Regeion set regionName = :regionName where regionId = :regionId");
		query.setParameter("regionName", "AMERICA");
		query.setParameter("regionId", 2);
		int result = query.executeUpdate();
		
		Query query =	session.createQuery("delete from Regeion  where regionId = :regionId");
		query.setParameter("regionId", 31);
		query.executeUpdate();
	
	
	String sql = "select * from regions";
		Query query = session.createSQLQuery(sql)
		        .addEntity(Regeion.class);
		List<Regeion> result = query.list();
		for(Regeion r:result){
			logger.info("{}",r.getRegionId());
		}
	
	insert
        Query query = session.createQuery("INSERT INTO Mother("
                + "firstName, lastName) "
                + "select c.firstName, c.lastName from Child as c");

		*/
		
		//commit	session.getTransaction().commit();
	}

}

