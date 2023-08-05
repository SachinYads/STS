package com.prodapt.restfulapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.restfulapp.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByName(String name) ;


}