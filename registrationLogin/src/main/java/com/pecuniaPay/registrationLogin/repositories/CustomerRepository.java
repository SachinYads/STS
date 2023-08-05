package com.pecuniaPay.registrationLogin.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.registrationLogin.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}