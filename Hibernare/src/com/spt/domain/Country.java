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
@Table(name="COUNTRIES")
public class Country {
		@Id
		@Column(name="COUNTRY_ID")
		String countryID="";
		@Column(name="COUNTRY_NAME")
		String countryName="";
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="REGION_ID", nullable = false)
		Regeion reg ;

			@OneToMany(fetch =FetchType.LAZY,mappedBy="countries")
			Set<Location> location;
		
	
		public Set<Location> getLocation() {
			return location;
		}
		public void setLocation(Set<Location> location) {
			this.location = location;
		}
	
		public Regeion getReg() {
			return reg;
		}
		public void setReg(Regeion reg) {
			this.reg = reg;
		}
		
		
		public String getCountryID() {
			return countryID;
		}
		public void setCountryID(String countryID) {
			this.countryID = countryID;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		
	
}
