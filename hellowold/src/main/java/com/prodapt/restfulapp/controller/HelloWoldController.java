package com.prodapt.restfulapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greet")
public class HelloWoldController {

		@GetMapping("/greeting")
		public String greetings() {
			return "Hello World ";
		}
}