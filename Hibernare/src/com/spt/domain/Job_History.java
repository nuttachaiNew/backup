package com.spt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_HISTORY")
public class Job_History {
	@Id
	@Column(name="EMPLOYEE_ID")
	Integer employeeID;
	@Column(name="START_DATE")
	java.util.Date startDate = new java.util.Date();
	@Column(name="END_DATE")
	java.util.Date endDate = new java.util.Date();

	//mapping 
	@Column(name="JOB_ID")
	String jobID="";
	@Column(name="DEPARTMENT_ID")
	Integer departmentID;
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public java.util.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
}
