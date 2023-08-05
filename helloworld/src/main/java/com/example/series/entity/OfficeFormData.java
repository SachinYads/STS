package com.example.series.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

public class OfficeFormData {
	//private Long officeId;
	private String officeName;
	//private Long addressId;
	private String street;
	private String city;
	private String state;
	private String country;
	public OfficeFormData() {
		super();
	}
	public OfficeFormData(String officeName, String street, String city, String state, String country) {
		super();
		this.officeName = officeName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "OfficeFormData [officeName=" + officeName + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}
}