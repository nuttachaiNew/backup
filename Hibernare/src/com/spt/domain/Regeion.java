package com.spt.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="REGIONS")
public class Regeion {
	
	@Id
	@Column(name="REGION_ID")
	 private Integer regionId;
	@Column(name="REGION_NAME")
	private	String regionName;

	@OneToMany(fetch =FetchType.LAZY,mappedBy="reg")
	Set<Country> countries;
	

	public Set<Country> getCountries() {
		return countries;
	}
	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
public Integer getRegionId() {
	return regionId;
}
public void setRegionId(Integer regionId) {
	this.regionId = regionId;
}
public String getRegionName() {
	return regionName;
}
public void setRegionName(String regionName) {
	this.regionName = regionName;
}

	
	
	
}
