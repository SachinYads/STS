package com.pecuniaPay.registrationLogin.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pecuniaPay.registrationLogin.entities.Customer;
import com.pecuniaPay.registrationLogin.entities.Registration;
import com.pecuniaPay.registrationLogin.exceptions.RegistrationClassNotFound;
import com.pecuniaPay.registrationLogin.repositories.CustomerRepository;
import com.pecuniaPay.registrationLogin.repositories.RegistrationRepository;
import com.pecuniaPay.registrationLogin.valueObjects.CustomerWallet;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer saveNewUser(Registration userDetails) {
		//userDetails.setWalletBalance(0);
		Customer cust = new Customer();
		cust.setUserDetails(userDetails);
//		cust.setWalletId(null);
		return customerRepo.save(cust);
	}

	@Override
	public Optional<Registration> getUserDetailsById(Long id) throws RegistrationClassNotFound {
		return registrationRepo.findById(id);
	}

}