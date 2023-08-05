package com.pecuniaPay.registrationLogin.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniaPay.registrationLogin.entities.Customer;
import com.pecuniaPay.registrationLogin.entities.Registration;
import com.pecuniaPay.registrationLogin.exceptions.RegistrationClassNotFound;
import com.pecuniaPay.registrationLogin.services.CustomerService;
import com.pecuniaPay.registrationLogin.services.RegistrationService;

@RestController
@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/newuser")
	public Customer saveNewUser(@RequestBody Registration userDetails)
	{
		return registrationService.saveNewUser(userDetails);
	}
	
	@GetMapping("/getuser/{id}")
	public Optional<Registration> getUserDetailsById(@PathVariable ("id") Long id) throws RegistrationClassNotFound
	{
		return registrationService.getUserDetailsById(id);
	}
	
	
	
	@GetMapping("getwalletid/{id}")
	public Long getWalletIdByCustomerId(@PathVariable ("id") Long id)
	{
		return customerService.getWalletIdByCustomerId(id);
	}
	
	@GetMapping("/getcustomer/{id}")
	public Optional<Customer> getCustomerDetailsById(@PathVariable ("id") Long id)
	{
		return customerService.getCustomerDetailsById(id);
	}
}