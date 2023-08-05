package com.example.series.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity


@Table(name="addresssachin")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long addressId;
private String street;
private String city;
private String state;
private String country;
@ManyToOne
@JoinColumn(name="officeID",nullable=false)
private Office office;
public Address() {
	super();
}

public Address(Long addressId, String street, String city, String state, String country, Office office) {
	super();
	this.addressId = addressId;
	this.street = street;
	this.city = city;
	this.state = state;
	this.country = country;
	this.office = office;
}
public Long getAddressId() {
	return addressId;
}
public void setAddressId(Long addressId) {
	this.addressId = addressId;
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
public Office getOffice() {
	return office;
}
public void setOffice(Office office) {
	this.office = office;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
			+ ", country=" + country +"]";
}
}
