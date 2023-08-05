package com.prodapt.restfulapp.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController//(@Coontroller+@ResponseBody)
public class EmployeeController {
	
	
    //localhost:8083/employees
	//@RequestMapping(value="/employees", method=HttpMethod.GET)
	@GetMapping("/emploees")
   public String getEmployees() {
	   return "dispaly the informatiomn abourt the employee";
   }
}
