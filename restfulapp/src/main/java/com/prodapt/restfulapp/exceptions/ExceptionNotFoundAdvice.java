package com.prodapt.restfulapp.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionNotFoundAdvice {
	 //@ResponseBody
	  @ExceptionHandler(EmployeeNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(EmployeeNotFoundException ex) {
	    return ex.getMessage() + ex.getId();
	  }

	  /**
	  //@ResponseBody
	  @ExceptionHandler(BookNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String bookNotFoundHandler(BookNotFoundException ex) {
	    return ex.getMessage();
	  }**/
}