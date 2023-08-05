package com.prodapt.restfulapp.exceptions;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

 

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmployeeNotFoundException extends Exception{
    String message;
    Long id;
    public EmployeeNotFoundException(Long id) {
		super("Could not find employee "+id);
	}
    public EmployeeNotFoundException(String name) {
		super("Could not find employee by "+name);
	}
}