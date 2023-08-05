package com.example.series.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="office_info")
public class Office {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long officeId;
	private String officeName;
	@Autowired
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Address>address;
	public Office() {
		super();
	}
	public Office(Long officeId, String officeName, Set<Address> address) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.address = address;
	}
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", officeName=" + officeName + ", address=" + address + "]";
	}
	

}
