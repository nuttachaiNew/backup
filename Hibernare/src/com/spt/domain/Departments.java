package com.spt.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departments")
public class Departments {
	@Id
	@Column(name="DEPARTMENT_ID")
	Integer departmentID=0;
	@Column(name="DEPARTMENT_NAME")
	String departmentName="";
	@Column(name="MANAGER_ID")
	String managerID="";
	//mapping
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID", nullable = false)
	Location location;
	
	@OneToMany(fetch =FetchType.LAZY,mappedBy="department")
	Set<Employees> employees; 
	
	public Set<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	
}
