package com.pecuniaPay.registrationLogin.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	@OneToOne(cascade = CascadeType.ALL)
	private Registration userDetails;
	private Long walletId;
	public Customer(Long custId, Registration userDetails, Long walletId) {
		super();
		this.custId = custId;
		this.userDetails = userDetails;
		this.walletId = walletId;
	}
	public Customer() {
		super();
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public Registration getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Registration userDetails) {
		this.userDetails = userDetails;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", userDetails=" + userDetails + ", walletId=" + walletId + "]";
	}
	
}