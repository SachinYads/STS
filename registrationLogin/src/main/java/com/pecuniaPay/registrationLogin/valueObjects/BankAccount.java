package com.pecuniaPay.registrationLogin.valueObjects;
public class BankAccount {
	private Long accountNumber;
	private String ifscCode;
	private Long bankBalance;
	private CustomerWallet wallet;
	public BankAccount(Long accountNumber, String ifscCode, Long bankBalance, CustomerWallet wallet) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankBalance = bankBalance;
		this.wallet = wallet;
	}
	public BankAccount() {
		super();
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Long getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(Long bankBalance) {
		this.bankBalance = bankBalance;
	}
	public CustomerWallet getWalletId() {
		return wallet;
	}
	public void setWalletId(CustomerWallet walletId) {
		this.wallet = walletId;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", bankBalance=" + bankBalance
				+ ", wallet=" + wallet + "]";
	}
	
	
}