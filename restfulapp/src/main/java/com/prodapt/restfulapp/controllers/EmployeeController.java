package com.prodapt.restfulapp.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.restfulapp.entities.Employee;
import com.prodapt.restfulapp.exceptions.EmployeeNotFoundException;
import com.prodapt.restfulapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	  @GetMapping("/employees")
	  List<Employee> all() {
	    return employeeService.all();
	  }


	  @PostMapping("/employees")
	  Employee newEmployee(@RequestBody Employee newEmployee) {
	    return employeeService.newEmployee(newEmployee);
	  }


	// Single item
	 // localhost:8083/swagger-ui/index.html#/employee-controller
	  @GetMapping("/employees/{id}")
	  Employee one(@PathVariable Long id) throws EmployeeNotFoundException {
		  return employeeService.one(id);
	  }

	  @PutMapping("/employees/{id}")
	  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		  return employeeService.replaceEmployee(newEmployee, id);
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		 employeeService.deleteEmployee(id);
	  }
	  @GetMapping("/searchemployeebyname/{name}")
	  ResponseEntity<Employee> findByName(@PathVariable String name) throws EmployeeNotFoundException{
			Employee emp = employeeService.findByName(name);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Responded", "EmployeeController");
		  return new ResponseEntity<>(emp,responseHeaders,HttpStatus.FOUND);
		}
}