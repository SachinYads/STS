package com.pecuniaPay.registrationLogin.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pecuniaPay.registrationLogin.entities.Registration;
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {
}