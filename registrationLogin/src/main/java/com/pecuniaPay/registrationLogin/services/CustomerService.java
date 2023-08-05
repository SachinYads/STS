package com.pecuniaPay.registrationLogin.services;
import java.util.Optional;

import com.pecuniaPay.registrationLogin.entities.Customer;

public interface CustomerService {
	public Optional<Customer> getCustomerDetailsById(Long id);

	public Long getWalletIdByCustomerId(Long id);
}