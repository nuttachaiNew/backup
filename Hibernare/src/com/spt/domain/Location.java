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
@Table(name="LOCATIONS")
public class Location {
	@Id
	@Column(name="LOCATION_ID")
	Integer locationID=0;
	@Column(name="STREET_ADDRESS")
	String streetAddress="";
	@Column(name="POSTAL_CODE")
	String postalCode="";
	@Column(name="CITY")
	String city="";
	@Column(name="STATE_PROVINCE")
	String stateProvince="";
	
	//mapping county
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID", nullable = false)
	Country countries;
	
	@OneToMany(fetch =FetchType.LAZY,mappedBy="location")
	Set<Departments> department;
	
	
	public Set<Departments> getDepartment() {
		return department;
	}
	public void setDepartment(Set<Departments> department) {
		this.department = department;
	}
	
	public Integer getLocationID() {
		return locationID;
	}
	public Country getCountries() {
		return countries;
	}
	public void setCountries(Country countries) {
		this.countries = countries;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
		
}
