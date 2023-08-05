package com.pecuniaPay.registrationLogin.valueObjects;
import java.util.Set;

public class CustomerWallet {

	private Long walletId;
	private Long walletBalance;
	private Set<BankAccount> linkedBanks;
	public CustomerWallet(Long walletId, Long walletBalance, Set<BankAccount> linkedBanks) {
		super();
		this.walletId = walletId;
		this.walletBalance = walletBalance;
		this.linkedBanks = linkedBanks;
	}
	public CustomerWallet() {
		super();
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Long walletBalance) {
		this.walletBalance = walletBalance;
	}
	public Set<BankAccount> getLinkedBanks() {
		return linkedBanks;
	}
	public void setLinkedBanks(Set<BankAccount> linkedBanks) {
		this.linkedBanks = linkedBanks;
	}
	@Override
	public String toString() {
		return "CustomerWallet [walletId=" + walletId + ", walletBalance=" + walletBalance + ", linkedBanks="
				+ linkedBanks + "]";
	}
	
}